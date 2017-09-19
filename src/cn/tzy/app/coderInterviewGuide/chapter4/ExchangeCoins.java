package cn.tzy.app.coderInterviewGuide.chapter4;

/**
 * Created by tuzhenyu on 17-9-19.
 * @author tuzhenyu
 */
public class ExchangeCoins {
    /**
     * 暴力递归
     * @param arr
     * @param sum
     * @return
     */
    private int exchangeCoins(int[] arr,int sum){
        if (arr==null||arr.length==0){
            return 0;
        }
        return exchange(arr,0,sum);
    }

    private int exchange(int[] arr,int index,int sum){
        int res = 0;
        if (index==arr.length){
            res = sum==0?1:0;
        }else {
            for (int i=0;arr[index]*i<=sum;i++){
                res += exchange(arr,index+1,sum-arr[index]*i);
            }
        }
        return res;
    }

    private int exchangeCoins2(int[] arr,int sum){
        if (arr==null||arr.length==0){
            return 0;
        }
        int[][] map = new int[arr.length+1][sum+1];
        return exchange2(arr,0,sum,map);
    }

    private int exchange2(int[] arr,int index,int sum,int[][] map){
        int res = 0;
        if (index==arr.length){
            res = sum==0?1:0;
        }else {
            for (int i=0;arr[index]*i<=sum;i++){
                int mapValue = map[index+1][sum-arr[index]*i];
                if (mapValue!=0)
                    res += mapValue==-1?0:mapValue;
                else
                    res += exchange(arr,index+1,sum-arr[index]*i);
            }
        }
        map[index][sum] = res==0?-1:res;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,10,50};
        int sum = 100;
        ExchangeCoins e = new ExchangeCoins();
        System.out.println(e.exchangeCoins2(arr,sum));
    }
}
