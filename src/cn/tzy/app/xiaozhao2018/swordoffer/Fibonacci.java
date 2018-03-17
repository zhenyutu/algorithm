package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-15.
 */
public class Fibonacci {
    public int fibonacci(int n){
        if (n==1||n==2)
            return n;
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public int fibonacci2(int n){
        if (n==1||n==2)
            return n;
        int a = 1;
        int b = 2;
        int c = a+b;
        for (int i=4;i<=n;i++){
            a = b;
            b = c;
            c = a+b;
        }
        return c;
    }
}
