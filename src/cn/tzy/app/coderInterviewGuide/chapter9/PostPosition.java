package cn.tzy.app.coderInterviewGuide.chapter9;

/**
 * Created by tuzhenyu on 18-1-23.
 * @author tuzhenyu
 */
public class PostPosition {
    public int select(int[] arr,int num){
        if (arr==null||arr.length==0||num<1)
            return -1;
        int[][] center = new int[arr.length][arr.length];
        int[][] dist = new int[arr.length][arr.length];
        int[][] dp = new int[num][arr.length];
        for (int i=0;i<arr.length;i++){
            for (int j=i;j<arr.length;j++){
                center[i][j] = arr[(i+j)/2];
            }
        }

        for (int i=0;i<arr.length;i++){
            for (int j=i;j<arr.length;j++){
                for (int k=i;k<=j;k++){
                    dist[i][j] += Math.abs(arr[center[i][j]]-arr[k]);
                }
            }
        }

        for (int i=0;i<arr.length;i++){
            dp[0][i] = dist[0][i];
        }
        for (int i=1;i<num;i++){
            for (int j=i+1;j<arr.length;j++){
                dp[i][j] = Integer.MAX_VALUE;
                for (int k=0;k<j;k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][k]+dist[k+1][j]);
                }
            }
        }

        return dp[num-1][arr.length-1];
    }

    public static void main(String[] args) {
        PostPosition p = new PostPosition();
        System.out.println(p.select(new int[]{0,1,2,3,4,5,6},3));
    }
}
