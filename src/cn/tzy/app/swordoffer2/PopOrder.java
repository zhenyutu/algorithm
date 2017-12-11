package cn.tzy.app.swordoffer2;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-12-11.
 * @author tuzhenyu
 */
public class PopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (popA==null||pushA==null)
            return false;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty()&&stack.peek()==popA[index]){
                stack.pop();
                index++;
            }
        }

        return stack.isEmpty();
    }

    public boolean IsPopOrder2(int [] pushA,int [] popA) {
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
