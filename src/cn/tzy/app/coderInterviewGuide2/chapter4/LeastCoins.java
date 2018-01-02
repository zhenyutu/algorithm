package cn.tzy.app.coderInterviewGuide2.chapter4;

/**
 * Created by tuzhenyu on 18-1-1.
 * @author tuzhenyu
 */
public class LeastCoins {
    public int leastCoins0(int[] arr,int arm){
        if (arr==null||arr.length==0||arm<0)
            return -1;
        int[] dp = new int[arm+1];
        for (int i=1;i<dp.length;i++){
            dp[i] = i;
        }
        for (int i=1;i<dp.length;i++){
            for (int j=0;j<arr.length;j++){
                if (i>arr[j]&&dp[i-arr[j]]+1<dp[i]){
                    dp[i] = dp[i-arr[j]]+1;
                }
            }
        }

        return dp[arm];
    }

    /**
     * 暴力递归
     * @param arr
     * @param arm
     * @return
     */
    public int leastCoins1(int[] arr,int arm){
        if (arr==null||arr.length==0||arm<0)
            return -1;
        return process1(arr,0,arm);
    }

    private int process1(int[] arr,int index,int arm){
        int res = 0;
        if (index==arr.length){
            res=arm==0?1:0;
        }else {
            for (int i=0;arr[index]*i<=arm;i++){
                res += process1(arr,index+1,arm-arr[index]*i);
            }
        }

        return res;
    }

    /**
     * 记忆搜索
     * @param arr
     * @param arm
     * @return
     */
    public int leastCoins2(int[] arr,int arm){
        if (arr==null||arr.length==0||arm<0)
            return -1;
        int[][] map = new int[arr.length+1][arm+1];
        return process2(arr,0,arm,map);
    }

    private int process2(int[] arr,int index,int arm,int[][] map){
        int res = 0;
        if (index==arr.length){
            res=arm==0?1:0;
        }else {
            int mapValue = 0;
            for (int i=0;arr[index]*i<=arm;i++){
                mapValue = map[index+1][arm-arr[index]*i];
                if (mapValue!=0)
                    res += mapValue==-1?0:mapValue;
                else
                    res += process1(arr,index+1,arm-arr[index]*i);
            }

        }
        map[index][arm] = res==0?-1:res;
        return res;
    }

    /**
     * 动态规划
     * @param arr
     * @param arm
     * @return
     */
    public int leastCoins3(int[] arr,int arm){
        if (arr==null||arr.length==0||arm<0)
            return -1;
        int[][] dp = new int[arr.length][arm+1];

        for (int i=0;i<arr.length;i++){
            dp[i][0]=1;
        }
        for (int j=1;j*arr[0]<=arm;j++){
                dp[0][j*arr[0]] = 1;
        }
        int num = 0;
        for (int i=1;i<arr.length;i++){
            for (int j=1;j<=arm;j++){
                num = 0;
                for (int k=0;j-k*arr[i]>=0;k++){
                    num += dp[i-1][j-k*arr[i]];
                }
                dp[i][j] = num;
            }
        }

        return dp[arr.length-1][arm];
    }

    public int leastCoins4(int[] arr,int arm){
        if (arr==null||arr.length==0||arm<0)
            return -1;
        int[][] dp = new int[arr.length][arm+1];

        for (int i=0;i<arr.length;i++){
            dp[i][0]=1;
        }
        for (int j=1;j*arr[0]<=arm;j++){
            dp[0][j*arr[0]] = 1;
        }
        int num = 0;
        for (int i=1;i<=arm;i++){
            for (int j=1;j<arr.length;j++){
                num = 0;
                for (int k=0;i-k*arr[j]>=0;k++){
                    num += dp[j-1][i-k*arr[j]];
                }
                dp[j][i] = num;
            }
        }

        return dp[arr.length-1][arm];
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5,10,25,1};
        int res = 15;
        LeastCoins l = new LeastCoins();
        System.out.println(l.leastCoins4(arr,res));
    }
}
