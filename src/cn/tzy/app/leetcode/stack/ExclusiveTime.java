package cn.tzy.app.leetcode.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-18.
 * @author tuzhenyu
 */
public class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        if (logs.size()==0)
            return null;
        int[] result = new int[n];
        int preTime = 0;
        for (String log : logs){
            String[] logStr = log.split(":");
            int name = Integer.parseInt(logStr[0]);
            int time = Integer.parseInt(logStr[2]);
            if ("start".equals(logStr[1])){
                if (!stack.isEmpty()){
                    int[] tmp = stack.peek();
                    result[tmp[0]] += (time-preTime);
                }
                stack.push(new int[]{name,time});
                preTime = time;

            }else {
                int[] tmp = stack.pop();
                result[tmp[0]] += (time-preTime+1);
                preTime = time+1;

            }
        }

        return result;
    }

    public static void main(String[] args) {
        ExclusiveTime e = new ExclusiveTime();
        List<String> list = new ArrayList<>();
        list.add("0:start:0");
        list.add("1:start:2");
        list.add("1:end:5");
        list.add("0:end:6");
        int[] result = e.exclusiveTime(2,list);
        for (int r : result){
            System.out.println(r);
        }
    }
}
