package cn.tzy.app.swordoffer2;

import java.util.ArrayList;

/**
 * Created by tuzhenyu on 17-12-11.
 * @author tuzhenyu
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix==null||matrix[0].length==0)
            return res;
        int tr=0,tb=0;
        int bl=matrix[0].length-1,bt=matrix.length-1;
        while (tr<=bl&&tb<=bt){
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
                for (int j=tb;j<bt;j++){
                    res.add(matrix[j][bl]);
                }
                for (int k=bl;k>tr;k--){
                    res.add(matrix[bt][k]);
                }
                for (int t=bt;t>tb;t--){
                    res.add(matrix[t][tr]);
                }
            }

            tr++;
            tb++;
            bl--;
            bt--;
        }

        return res;
    }

    public ArrayList<Integer> printMatrix2(int [][] matrix) {
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

    public static void main(String[] args) {
        PrintMatrix p = new PrintMatrix();
//        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(p.printMatrix(arr).toString());
    }
}
