package cn.tzy.app.coderInterviewGuide.chapter4;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-9-18.
 * @author tuzhenyu
 */
public class NumberTower {
    /**
     * 暴力递归 时间复杂度指数增长
     * @param arr
     * @return
     */
    public static int numTower(int[][] arr){
        return max(arr,0,0);
    }

    private static int max(int[][] arr,int i,int j){
        int left,right;
        if (i==arr.length-1)
            return arr[i][j];
        left = max(arr,i+1,j);
        right = max(arr,i+1,j+1);
        return left>right?arr[i][j]+left:arr[i][j]+right;
    }


    public static int numTower2(int[][] arr){
        int[][] cost = new int[arr.length][arr.length];
        for (int i=0;i<arr.length;i++){
            Arrays.fill(cost[i],-1);
        }
        return max2(arr,0,0,cost);
    }

    private static int max2(int[][] arr,int i,int j,int[][] cost){
        int left,right;
        if (i==arr.length-1)
            return arr[i][j];
        if (cost[i][j]>0)
            return cost[i][j];

        left = max(arr,i+1,j);
        right = max(arr,i+1,j+1);
        cost[i][j] = left>right?arr[i][j]+left:arr[i][j]+right;
        return cost[i][j];
    }

    public static void main(String[] args) {
        int[][] arr = {{9},{12,15},{10,6,8},{2,18,9,5},{19,7,10,4,16}};
        System.out.println(numTower2(arr));
    }
}
