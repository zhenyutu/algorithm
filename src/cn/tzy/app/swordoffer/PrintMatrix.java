package cn.tzy.app.swordoffer;

import java.util.ArrayList;

/**
 * Created by tuzhenyu on 17-11-2.
 * @author tuzhenyu
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix==null||matrix[0].length==0)
            return null;
        ArrayList<Integer> res = new ArrayList<>();
        int tr=0,tb=0;
        int bt=matrix.length-1,bl=matrix[0].length-1;
        while (bl>=tr&&bt>=tb){
            printSubMatrix(matrix,tr++,tb++,bl--,bt--,res);
        }
        return res;
    }

    private void printSubMatrix(int [][] matrix,int tr,int tb,int bl,int bt,ArrayList<Integer> res){
        if (tr==bl){
            for (int i=tb;i<=bt;i++){
                res.add(matrix[i][tr]);
            }
        }else if (tb==bt){
            for (int i=tr;i<=bl;i++){
                res.add(matrix[tb][i]);
            }
        }else {
            for (int i=tr;i<bl;i++){
                res.add(matrix[tb][i]);
            }

            for (int i=tb;i<bt;i++){
                res.add(matrix[i][bl]);
            }
            for (int i=bl;i>tr;i--){
                res.add(matrix[bt][i]);
            }
            for (int i=bt;i>tb;i--){
                res.add(matrix[i][tr]);
            }
        }
    }
}
