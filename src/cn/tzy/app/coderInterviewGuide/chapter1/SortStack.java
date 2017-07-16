package cn.tzy.app.coderInterviewGuide.chapter1;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-7-16.
 * @author tuzhenyu
 */
public class SortStack {
    public static void sort(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();

        while (!stack.isEmpty()){
            Integer elem = stack.pop();
            while (!help.isEmpty()&&help.peek()<elem){
                stack.push(help.pop());
            }
            help.push(elem);
        }
        while (!help.isEmpty())
            stack.push(help.pop());
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(3);
        stack.push(6);
        stack.push(4);
        stack.push(0);

        sort(stack);

        for (int elem : stack){
            System.out.println(elem);
        }
    }
}
