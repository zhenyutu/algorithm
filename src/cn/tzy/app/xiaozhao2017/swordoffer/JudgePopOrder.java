package cn.tzy.app.xiaozhao2017.swordoffer;

import java.util.Stack;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class JudgePopOrder {
    public boolean isPopOrder(int[] push,int[] pop){
        if (push==null||pop==null)
            return false;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i=0;i<push.length;i++){
            stack.push(push[i]);
            while (!stack.isEmpty()&&stack.peek()==pop[index]){
                stack.pop();
                index++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        JudgePopOrder j = new JudgePopOrder();
        System.out.println(j.isPopOrder(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
        System.out.println(j.isPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
    }}
