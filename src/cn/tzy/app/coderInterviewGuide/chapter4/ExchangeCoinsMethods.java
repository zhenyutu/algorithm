package cn.tzy.app.coderInterviewGuide.chapter4;

/**
 * Created by tuzhenyu on 17-9-27.
 * @author tuzhenyu
 */
public class ExchangeCoinsMethods {
    public int exchange(int[] coins,int target){
        if (coins==null||coins.length==0||target<0)
            return 0;
        return getTarget(coins,0,target);
    }

    private int getTarget(int[] coins,int index,int target){
        int res = 0;
        if (index==coins.length)
            res = target==0?1:0;
        else {
            for (int i=0;coins[index]*i<=target;i++){
                res += getTarget(coins,index+1,target-coins[index]*i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] coins = {5,10,25,1};
        ExchangeCoinsMethods e = new ExchangeCoinsMethods();
        System.out.println(e.exchange(coins,15));
    }
}
