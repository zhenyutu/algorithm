package cn.tzy.app.swordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuzhenyu on 17-4-29.
 * @author tuzhenyu
 */
public class Solution010 {
    /**
     *青蛙跳台阶可以想到在第n阶的时候f(n)=f(n-1)+f(n-2)种跳法，类似为斐波那契数列，只是起点数列不一样
     * 33ms 636k
     */
    public static int JumpFloor(int target) {
        List<Integer> list = new ArrayList<>();
        if (target==1||target==2){
            return target;
        }
        if (target>2){
            list.add(0);
            list.add(1);
            list.add(2);
            for (int i=3;i<=target;i++){
                list.add(list.get(i-1)+list.get(i-2));
            }
        }
        return list.get(target);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(JumpFloor(n));
    }
}
