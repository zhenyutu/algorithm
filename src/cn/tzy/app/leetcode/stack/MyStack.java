package cn.tzy.app.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by tuzhenyu on 17-8-15.
 * @author tuzhenyu
 * leetcode_225
 */
public class MyStack {
    private Deque<Integer> queue1;
    private Deque<Integer> queue2;
    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    public void push(int x) {
        if (!queue1.isEmpty())
            queue1.add(x);
        else
            queue2.add(x);
    }

    public int pop() {
        Deque<Integer> queuePush = queue1.isEmpty()?queue2:queue1;
        Deque<Integer> queuePop = queue1.isEmpty()?queue1:queue2;
        while (queuePush.size()>1){
            queuePop.add(queuePush.poll());
        }
        return queuePush.poll();
    }

    public int top() {
        Deque<Integer> queuePush = queue1.isEmpty()?queue2:queue1;
        Deque<Integer> queuePop = queue1.isEmpty()?queue1:queue2;
        while (queuePush.size()>1){
            queuePop.add(queuePush.poll());
        }
        int tmp = queuePush.poll();
        queuePop.add(tmp);
        return tmp;
    }

    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
