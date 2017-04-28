package cn.tzy.app.swordOffer;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-4-28.
 * @author tuzhenyu
 */
public class Solution007 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 本题是通过两个栈结构模拟队列结构，基本思路就是在输出栈为空的时候将输入栈一次清空放入输出栈，负负得正从而实现两次先进后出得到先进先出
     * 特别要注意的是在for循环中以stack.size()为判断条件的必须注意在循环中stack是否变化，如果变化则会循环遍历出错
     * 28ms 629k
     */
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()&&!stack1.isEmpty()){
            int size = stack1.size();
            for (int i=0;i<size;i++){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Solution007 s = new Solution007();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
