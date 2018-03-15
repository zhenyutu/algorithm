package cn.tzy.app.xiaozhao2017.swordoffer;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by tuzhenyu on 18-3-15.
 * @author tuzhenyu
 */
public class SlideWindow {
    private List<Integer> res = new ArrayList<>();
    private Deque<Integer> queue = new ArrayDeque<>();

    public List<Integer> maxInWindow(int[] num,int size){
        if (num==null||num.length==0||num.length<size)
            return res;
        for (int i=0;i<num.length;i++){
            while (!queue.isEmpty()&&i-queue.peekFirst()>=size)
                queue.pollFirst();
            while (!queue.isEmpty()&&num[queue.peekLast()]<num[i])
                queue.pollLast();
            queue.offer(num[i]);
            if (i>=size-1){
                res.add(num[queue.peekFirst()]);
            }
        }
        return res;
    }

    public static void main(String[] args){

    }
}
