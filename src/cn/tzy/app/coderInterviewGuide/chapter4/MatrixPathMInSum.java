package cn.tzy.app.coderInterviewGuide.chapter4;

/**
 * Created by tuzhenyu on 17-9-25.
 * @author tuzhenyu
 */
public class MatrixPathMInSum {
    public int minPathSum(int[][] arr){
        return getMinSum(arr,0,0);
    }

    private int getMinSum(int[][] arr,int i,int j){
        if (i==arr.length-1&&j==arr.length-1){
            return arr[i][j];
        }
        int bm,rm;
        if (i<arr.length-1)
            bm = getMinSum(arr,i+1,j);
        else
            bm = Integer.MAX_VALUE;

        if (j<arr.length-1)
            rm = getMinSum(arr,i,j+1);
        else
            rm = Integer.MAX_VALUE;

        return bm<rm?bm+arr[i][j]:rm+arr[i][j];

    }

    public static void main(String[] args) {
        MatrixPathMInSum m = new MatrixPathMInSum();
        int[][] arr = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        System.out.println(m.minPathSum(arr));
    }
}
