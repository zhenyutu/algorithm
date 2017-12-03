package cn.tzy.app.swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by tuzhenyu on 17-12-3.
 * @author tuzhenyu
 */
public class SlideWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        LinkedList<Integer> max = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (num==null||size<=0||num.length<size)
            return res;

        for (int i=0;i<num.length;i++){
            while (!max.isEmpty()&&num[max.peekLast()]<num[i])
                max.pollLast();
            while (!max.isEmpty()&&num[max.peekFirst()]<=num[i])
                max.pollFirst();
            max.addLast(i);
            if (max.peekFirst()==i-size)
                max.pollFirst();
            if (i>=size-1)
                res.add(num[max.peekFirst()]);
        }

        return res;
    }

    public static void main(String[] args) {
        SlideWindow s = new SlideWindow();
        System.out.println(s.maxInWindows(new int[]{2,3,4,2,6,2,5,1},3).toString());
    }
}
