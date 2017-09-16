package cn.tzy.app.coderInterviewGuide.chapter4;

/**
 * Created by tuzhenyu on 17-9-16.
 * @author tuzhenyu
 */
public class Fibonacci {

    /**
     * 暴力递归,事件复杂度O(2^n)
     * @param n
     * @return
     */
    public int fibonacci1(int n){
        if (n<1)
            return 0;
        if (n==1||n==2){
            return 1;
        }

        return fibonacci1(n-1)+fibonacci1(n-2);
    }

    /**
     * 递推法 时间复杂度O(n)
     * @param n
     * @return
     */
    public int fibonacci2(int n){
        if (n<1)
            return 0;
        if (n==1||n==2){
            return 1;
        }

        int res = 1;
        int pre = 1;
        int tmp = 0;
        for (int i=3;i<=n;i++){
            tmp = res;
            res = pre + res;
            pre = tmp;
        }
        return res;
    }


    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        for (int i=1;i<10;i++){
            System.out.println(String.format(i+": %d",f.fibonacci2(i)));
        }
    }
}
