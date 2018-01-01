package cn.tzy.app.coderInterviewGuide2.chapter4;

/**
 * Created by tuzhenyu on 18-1-1.
 * @author tuzhenyu
 */
public class MInPathInMaxtri {
    public int getMin(int[][] m){
        if (m==null||m.length==0||m[0].length==0)
            return -1;
        int row = m.length;
        int column = m[0].length;
        int[][] res = new int[row][column];
        for (int i=1;i<row;i++){
            res[i][0] = m[i][0] + res[i-1][0];
        }
        for (int j=1;j<column;j++){
            res[0][j] = m[0][j] + m[0][j-1];
        }

        for (int i=1;i<row;i++){
            for (int j=1;j<column;j++){
                res[i][j] = Math.max(res[i-1][j],res[i][j-1])+m[i][j];
            }
        }

        return res[row-1][column-1];
    }
}

