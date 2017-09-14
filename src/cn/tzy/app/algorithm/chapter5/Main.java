package cn.tzy.app.algorithm.chapter5;

/**
 * Created by tuzhenyu on 17-9-13.
 * @author tuzhenyu
 */
public class Main {
    private static int getNum(){
        int addOperate = 0;
        int multiOperate = 0;
        int a = 100;
        int b = 1000;
        int A = 202;
        int B = 2002;
        while (true){
            if (A%2==0&&B%2==0){
                A = A/2;
                B = B/2;
                multiOperate++;
            }else{
                A = A - 1;
                B = B - 1;
                addOperate++;
            }

            if ((A==a&&B!=b)||(A!=a&&B==b))
                return -1;

            if (A==a && B==b)
                return addOperate+multiOperate;
        }
    }
    public static void main(String[] args) {
        System.out.println(getNum());
    }
}
