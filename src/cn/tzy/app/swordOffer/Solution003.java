package cn.tzy.app.swordOffer;

/**
 * Created by tuzhenyu on 17-4-25.
 * @author tuzhenyu
 */
public class Solution003 {
    public static boolean Find(int target, int [][] array) {
        boolean result = false;

        int rowStart = 0;
        int rowEnd = array[0].length-1;
        int columnStart = 0;
        int columnEnd = array.length-1;

        if (array[rowStart][columnStart]==target||array[rowEnd][columnEnd]==target){
            return true;
        }

        while (rowStart!=rowEnd||columnStart!=columnEnd){
            int rowMid = rowStart+(rowStart+rowEnd)/2;
            int cloumnMid = columnStart+(columnStart+columnEnd)/2;
            if (array[rowMid][cloumnMid]>target){
                rowEnd = rowMid-1;
                columnEnd = cloumnMid-1;
            }else if (array[rowMid][cloumnMid]<target){
                rowStart = rowMid+1;
                columnStart = cloumnMid+1;
            }else {
                result = true;
                break;
            }
        }

        return result;
    }

    public static boolean Find2(int target, int [][] array) {
        boolean result = false;
        int columnLength = array.length;

        for (int i=0;i<columnLength;i++){
            int rowLength = array[i].length;
            if(rowLength!=0&&array[i][0]<=target&&array[i][rowLength-1]>=target){
                for (int j=0;j<rowLength;j++){
                    if (array[i][j] == target){
                        result = true;
                        break;
                    }
                }
            }
            if (result==true)
                break;

        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] test = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] test = {{}};
        int target = 6;
        System.out.println(Find2(target,test));
    }
}
