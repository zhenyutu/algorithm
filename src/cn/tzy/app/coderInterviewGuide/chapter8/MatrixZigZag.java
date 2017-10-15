package cn.tzy.app.coderInterviewGuide.chapter8;

/**
 * Created by tuzhenyu on 17-10-14.
 * @author tuzhenyu
 */
public class MatrixZigZag {
    public void printMatriZigZag(int[][] arr){
        int t1 = 0;
        int t2 = 0;
        int b1 = 0;
        int b2 = 0;
        int end1 = arr.length-1;
        int end2 = arr[0].length-1;
        boolean flag = false;
        while (t1!=end1+1){
            printLevel(arr,t1,t2,b1,b2,flag);
            t1 = t2==end2?t1+1:t1;
            t2 = t2==end2?t2:t2+1;
            b2 = b1==end1?b2+1:b2;
            b1 = b1==end1?b1:b1+1;
            flag = !flag;
        }


    }
    private void printLevel(int[][] arr,int t1,int t2,int b1,int b2,boolean flag){
        if (flag){
            while (t1!=b1+1){
                System.out.print(arr[t1++][t2--] + " ");
            }
        }else {
            while (b2!=t2+1){
                System.out.print(arr[b1--][b2++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        MatrixZigZag m = new MatrixZigZag();
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        m.printMatriZigZag(arr);
    }
}
