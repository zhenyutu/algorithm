package cn.tzy.app.swordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuzhenyu on 17-4-29.
 * @author tuzhenyu
 */
public class Solution011 {
    /**
     *变态青蛙跳是指每一步都能跳n个台阶,则f(n)=f(n-1)+f(n-2)+...+f(1)也就是当前项就是前面所有项的和
     *集合每一项等于前面所有项的和，则a[n]=2a[n-1]
     * 30ms 636k
     */
    public static int JumpFloorII(int target) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);

        if (target>1){
            for (int i=2;i<=target;i++){
                list.add(list.get(i-1)*2);
            }
        }
        return list.get(target);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(JumpFloorII(n));
    }
}
