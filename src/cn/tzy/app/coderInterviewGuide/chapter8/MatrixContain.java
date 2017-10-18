package cn.tzy.app.coderInterviewGuide.chapter8;

/**
 * Created by tuzhenyu on 17-10-18.
 * @author tuzhenyu
 */
public class MatrixContain {
    public boolean contain(int[][] arr,int target){
        int row = 0;
        int col = arr[0].length;
        while (row<arr.length&&col>-1){
            if (arr[row][col]>target){
                col--;
            }else if(arr[row][col]<target){
                row++;
            }else {
                return true;
            }
        }
        return false;
    }
}
