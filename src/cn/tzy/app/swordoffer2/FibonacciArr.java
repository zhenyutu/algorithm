package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-9.
 * @author tuzhenyu
 */
public class FibonacciArr {
    public int Fibonacci(int n) {
        if (n==0||n==1)
            return n;
        if (n==2)
            return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public int Fibonacci2(int n){
        if (n==0||n==1)
            return n;
        else if (n==2)
            return 1;
        else {
            int a = 1,b=1,c=2;
            for (int i=3;i<n;i++){
                a = b;
                b = c;
                c = a+b;
            }
            return c;
        }
    }

    public static void main(String[] args) {
        FibonacciArr f = new FibonacciArr();
        System.out.println(f.Fibonacci2(9));
    }
}
