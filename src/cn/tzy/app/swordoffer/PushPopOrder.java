package cn.tzy.app.swordoffer;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-11-3.
 */
public class PushPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length==0)
            return false;
        Stack<Integer> stack = new Stack<>();
        for (int i=0,j=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty()&&stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
