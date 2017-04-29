package cn.tzy.app.swordOffer;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuzhenyu on 17-4-29.
 * @author tuzhenyu
 */
public class Solution012 {
    /**
     *小矩形覆盖大矩形，归根到底还是斐波那契数列
     * 27ms 636k
     */
    public static int RectCover(int target) {
        List<Integer> list = new ArrayList<>();
        if (target==1||target==0){
            return target;
        }
        if (target>1){
            list.add(1);
            list.add(1);
            for (int i=2;i<=target;i++){
                list.add(list.get(i-1)+list.get(i-2));
            }
        }
        return list.get(target);
    }

    public static void main(String[] args) {
        int target = 5;
        System.out.println(RectCover(target));
    }
}
