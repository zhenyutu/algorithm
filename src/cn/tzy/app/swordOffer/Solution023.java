package cn.tzy.app.swordOffer;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-5-9.
 * @author tuzhenyu
 */
public class Solution023 {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length==0)
            return false;
        Stack<Integer> stack = new Stack<>();
        for (int i=0,j=0;i<pushA.length;){
            stack.push(pushA[i++]);
            while (j<popA.length&&stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
