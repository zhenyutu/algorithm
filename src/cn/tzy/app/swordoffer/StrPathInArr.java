package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-12-3.
 * @author tuzhenyu
 */
public class StrPathInArr {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        int[] flag = new int[matrix.length];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (explore(matrix,rows,cols,i,j,flag,0,str))
                    return true;
            }
        }
        return false;
    }

    private boolean explore(char[] matrix, int rows, int cols, int i, int j,
                            int[] flag, int k, char[] str){
        int index = i*cols+j;
        if (i < 0 || i >= rows || j < 0 || j >= cols ||matrix[index]!=str[k]||flag[index]==1)
            return false;
        if (k==str.length-1)
            return true;
        flag[index] = 1;
        if (explore(matrix,rows,cols,i-1,j,flag,k+1,str)||
                explore(matrix,rows,cols,i+1,j,flag,k+1,str)||
                explore(matrix,rows,cols,i,j-1,flag,k+1,str)||
                explore(matrix,rows,cols,i,j+1,flag,k+1,str))
            return true;
        flag[index] = 0;
        return false;
    }
}
