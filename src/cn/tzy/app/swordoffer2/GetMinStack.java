package cn.tzy.app.swordoffer2;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-12-11.
 * @author tuzhenyu
 */
public class GetMinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (min.isEmpty()) {
            min.push(node);
        } else{
            min.push(min.peek()<node?min.peek():node);
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }

//    public void push(int node) {
//        stack.push(node);
//        if (minStack.size()==0||node<minStack.peek()){
//            minStack.push(node);
//        }else {
//            minStack.push(minStack.peek());
//        }
//    }
//
//    public void pop() {
//        stack.pop();
//        minStack.pop();
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int min() {
//        return minStack.peek();
//    }
}
