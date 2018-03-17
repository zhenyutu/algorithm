package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-15.
 * @author tuzhenyu
 */
public class MaxtriSearch {
    public boolean search(int[][] maxtri,int target){
        if (maxtri==null||maxtri.length==0||maxtri[0].length==0)
            return false;
        int rowEnd = maxtri.length-1;
        int columnEnd = maxtri[0].length-1;
        int row = 0,column = columnEnd;
        while (row<=rowEnd-1&&column>=0){
            if (maxtri[row][column]<target)
                row++;
            else if (maxtri[row][column]>target)
                column--;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MaxtriSearch m = new MaxtriSearch();
        System.out.println(m.search(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}},10));
    }
}
