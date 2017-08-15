package cn.tzy.app.leetcode.stack;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-15.
 * @author tuzhenyu
 * leetcode_232
 */
public class MyQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;
    public MyQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void push(int x) {
        while (!stackPop.isEmpty()){
            stackPush.push(stackPop.pop());
        }
        stackPush.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stackPush.isEmpty()){
            stackPop.push(stackPush.pop());
        }
        return stackPop.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!stackPush.isEmpty()){
            stackPop.push(stackPush.pop());
        }
        return stackPop.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackPush.isEmpty()&&stackPop.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
