package cn.tzy.app.coderInterviewGuide.chapter4;

/**
 * Created by tuzhenyu on 17-9-18.
 * @author tuzhenyu
 */
public class NumberTower {
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

    public static void main(String[] args) {
        int[][] arr = {{9},{12,15},{10,6,8},{2,18,9,5},{19,7,10,4,16}};
        System.out.println(numTower(arr));
    }
}
