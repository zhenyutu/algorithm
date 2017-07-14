package cn.tzy.app.coderInterviewGuide.chapter1;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-7-14.
 * @author tuzhenyu
 */
public class Stack2Queue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void add(Integer t){
        if (!stack2.isEmpty()){
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        stack1.push(t);
    }

    public Integer poll()throws Exception{
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        if (stack2.isEmpty())
            throw new Exception("empty");
        return stack2.pop();
    }

    public Integer peek()throws Exception{
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        if (stack2.isEmpty())
            throw new Exception("empty");
        return stack2.peek();
    }

    public static void main(String[] args) throws Exception{
        Stack2Queue sq = new Stack2Queue();

        sq.add(1);
        System.out.println(sq.peek());
        sq.add(2);
        System.out.println(sq.peek());
        sq.add(3);
        System.out.println(sq.peek());

        System.out.println(sq.poll());
        System.out.println(sq.poll());
        System.out.println(sq.poll());

        sq.add(1);
        System.out.println(sq.peek());
        sq.add(2);
        System.out.println(sq.peek());
        sq.add(3);
        System.out.println(sq.peek());
    }
}
