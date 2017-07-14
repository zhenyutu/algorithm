package cn.tzy.app.coderInterviewGuide.chapter1;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-7-11.
 * @author tuzhenyu
 */
public class GetMInStack {
    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    public void push(Integer t){
        stackData.push(t);
        if (stackMin.isEmpty()){
            stackMin.push(t);
        }else if (stackMin.peek()>t){
            stackMin.push(t);
        }
    }

    public Integer pop(){
        int tmp = stackData.pop();
        if (stackMin.peek() == tmp)
            stackMin.pop();
        return tmp;
    }

    public void push2(Integer t){
        stackData.push(t);
        if (stackMin.isEmpty()){
            stackMin.push(t);
        }else if (stackMin.peek()>t){
            stackMin.push(t);
        }else{
            stackMin.push(stackMin.peek());
        }
    }

    public Integer pop2(){
        int tmp = stackData.pop();
        stackMin.pop();
        return tmp;
    }

    public Integer getMin(){
        return stackMin.peek();
    }

    public static void main(String[] args) {
        GetMInStack stack = new GetMInStack();

        stack.push(10);
        stack.push(20);
        stack.push(4);
        stack.push(28);
        stack.push(6);

        System.out.println(stack.pop());
        System.out.println(stack.getMin());

        System.out.println(stack.pop());
        System.out.println(stack.getMin());

        System.out.println(stack.pop());
        System.out.println(stack.getMin());

        System.out.println("================");

        stack.push2(10);
        stack.push2(20);
        stack.push2(4);
        stack.push2(28);
        stack.push2(6);

        System.out.println(stack.pop2());
        System.out.println(stack.getMin());

        System.out.println(stack.pop2());
        System.out.println(stack.getMin());

        System.out.println(stack.pop2());
        System.out.println(stack.getMin());
    }

}
