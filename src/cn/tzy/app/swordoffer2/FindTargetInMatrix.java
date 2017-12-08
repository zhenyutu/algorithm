package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-8.
 * @author tuzhenyu
 */
public class FindTargetInMatrix {
    public boolean Find(int target, int [][] array) {
        if (array==null||array.length==0||array[0].length==0)
            return false;
        int rowEnd = array.length;
        int columnEnd = array[0].length;
        int i = 0,j=columnEnd-1;
        while (i<rowEnd&&j>=0){
            if (array[i][j]>target){
                j--;
            }else if (array[i][j]<target){
                i++;
            }else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        FindTargetInMatrix f = new FindTargetInMatrix();
        System.out.println(f.Find(10,arr));
    }
}
