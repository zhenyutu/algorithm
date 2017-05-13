package cn.tzy.app.swordOffer;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by tuzhenyu on 17-5-7.
 * @author tuzhenyu
 */
public class Solution021 {
    /**
     *  1   2   3   4
     *  5   6   7   8
     *  9   10  11  12
     *  13  14  15  16
     *  标记数组mark[][],根据右下左上的优先级别进行寻路
     *  错误
     */
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix==null)
            return null;
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        int i = 0;
        int j = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[][] marked = new boolean[row][column];
        for (int s=0;s<row;s++){
            for (int t=0;t<column;t++){
                marked[s][t]=false;
            }
        }
        while (count<matrix.length*matrix[0].length){
            if (j+1<column&&!marked[i][j+1]){
                j++;
                list.add(matrix[i][j]);
                continue;
            }
            if (i+1<row&&!marked[i+1][j]){
                i++;
                list.add(matrix[i][j]);
                continue;
            }
            if (j-1>=0&&!marked[i][j-1]){
                j--;
                list.add(matrix[i][j]);
                continue;
            }
            if (i-1>=0&&!marked[i-1][j]){
                i--;
                list.add(matrix[i][j]);
                continue;
            }
            break;
        }
        return list;
    }

    public static ArrayList<Integer> printMatrix2(int [][] matrix) {
        if (matrix==null||matrix.length==0)
            return null;
        ArrayList<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0;
        while (start*2<row&&start*2<column){
            printCirle(list,matrix,row,column,start);
            start++;
        }
        return list;
    }

    private static void printCirle(ArrayList<Integer> list,int [][] matrix,int row,int column,int start){
        int endX = column-1-start;
        int endY = row - 1 - start;

        for (int i= start;i<=endX;++i){
            list.add(matrix[start][i]);
            System.out.println(matrix[start][i]);
        }
        if (start<endY){
            for (int i=start+1;i<=endY;++i){
                list.add(matrix[i][endX]);
                System.out.println(matrix[i][endX]);
            }
        }
        if (start<endX&&start<endY){
            for(int i=endX-1;i>=start;--i){
                list.add(matrix[endY][i]);
                System.out.println(matrix[endY][i]);
            }
        }
        if (start<endX&&start<endY-1){
            for (int i= endY-1;i>=start+1;--i){
                list.add(matrix[i][start]);
                System.out.println(matrix[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] list = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List result = printMatrix2(list);
//        System.out.println(result.toString());
    }
}
