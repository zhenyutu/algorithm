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

    public int exchange2(int[] coins,int target){
        if (coins==null||coins.length==0||target<0)
            return 0;
        int[][] map = new int[coins.length+1][target+1];
        return getTarget2(coins,0,target,map);
    }

    private int getTarget2(int[] coins,int index,int target,int[][] map){
        int res = 0;
        if (index==coins.length)
            res = target==0?1:0;
        else {
            int mapValue = 0;
            for (int i=0;coins[index]*i<=target;i++){
                mapValue = map[index+1][target-coins[index]*i];
                if (mapValue!=0){
                    res += mapValue==-1?0:mapValue;
                }else {
                    res += getTarget2(coins,index+1,target-coins[index]*i,map);
                }
            }
        }
        map[index][target] = res==0?-1:res;
        return res;
    }

    public int exchange3(int target){
        if (target<0)
            return 0;
        return getTarget3(1,target);
    }

    private int getTarget3(int index,int target){
        int res = 0;
        if (index>target){
            return target==0?1:0;
        }else {
            for (int i=0;target-index*i>=0&&i<=2;i++){
                res += getTarget3(index+1,target-index*i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] coins = {5,10,25,1};
        ExchangeCoinsMethods e = new ExchangeCoinsMethods();
//        System.out.println(e.exchange(coins,15));
        System.out.println(e.exchange3(10));
    }
}
