package cn.tzy.app.xiaozhao2018.swordoffer;

import java.util.Stack;

/**
 * Created by tuzhenyu on 18-3-15.
 * @author tuzhenyu
 */
public class TwoStackQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int val){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack2.push(val);
    }

    public int poll(){
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return stack1.pop();
    }
}
