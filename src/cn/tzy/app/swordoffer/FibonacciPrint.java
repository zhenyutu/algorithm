package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-10-30.
 * @author tuzhenyu
 */
public class FibonacciPrint {
    public int Fibonacci(int n) {
        if (n<1)
            return 0;
        if (n==1||n==2)
            return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public int Fibonacci2(int n) {
        if (n<1)
            return 0;
        if (n==1)
            return 1;
        int prepre = 0;
        int pre = 1;
        int res = 1;
        for (int i=1;i<n;i++){
            res = pre + prepre;
            prepre = pre;
            pre = res;
        }

        return res;
    }

    public static void main(String[] args) {
        FibonacciPrint f = new FibonacciPrint();
        System.out.println(f.Fibonacci2(10));
    }
}
