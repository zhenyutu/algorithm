package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-10-27.
 * @author tuzhenyu
 */
public class FindTargetInMaxtri {
    public boolean Find(int target, int [][] array) {
        if(array==null||array.length==0||array[0].length==0)
            return false;
        int rowEnd = array.length-1;
        int clownEnd = array[0].length-1;
        int row = 0;
        int clown = clownEnd;
        while (row<=rowEnd&&clown>=0){
            if (array[row][clown]<target){
                row++;
            }else if (array[row][clown]>target){
                clown--;
            }else
                return true;
        }
        return false;
    }
}
