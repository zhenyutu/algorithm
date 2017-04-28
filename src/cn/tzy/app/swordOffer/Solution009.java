package cn.tzy.app.swordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuzhenyu on 17-4-28.
 * @author tuzhenyu
 */
public class Solution009 {
    /**
     *斐波那契数列,每一项都等于前两项之和
     *创建列表存储数列，根据a[n]=a[n-1]+a[n-2]求出第n个数，添加进数列依次循环
     * 30ms 636k
     */
    public static int Fibonacci(int n) {
        List<Integer> list = new ArrayList<>();
        if (n==1||n==2){
            return 1;
        }else if (n>2){
            list.add(1);
            list.add(1);
            for (int i=3;i<=n;i++){
                int tmp = list.get(list.size()-1)+list.get(list.size()-2);
                list.add(tmp);
            }
            return list.get(list.size()-1);
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int n = 0;
        System.out.println(Fibonacci(n));
    }
}
