package cn.tzy.app.swordOffer;

/**
 * Created by tuzhenyu on 17-4-30.
 * @author tuzhenyu
 */
public class Solution013 {
    /**
     *二进制中的1的个数，有两种思路：将1进行左移与n进行与运算；将n进行右移与1进行与运算
     * 将n进行右移与1进行与运算,如果是负数则右移最高位补1,最终的结果是0XFFFFFFFF程序陷入死循环
     * 将1进行左移与n进行与运算,结束条件是当1左移到符号位，为0
     * 29ms 629k
     */
    public static int NumberOf1(int n) {
        int count = 0;
        int flag = 1;

        while (flag!=0){
            if ((n&flag)!=0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    /**
     *最优解法
     * 一个数减去1再与自身进行与运算，可以将最靠后的一位二进制1变成0
     *31ms 654k
     */
    public static int NumberOf12(int n) {
        int count = 0;
        while (n!=0){
            ++count;
            n = n & (n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(NumberOf12(n));
    }
}
