package cn.tzy.app.dataStructure.chapter4;

/**
 * Created by tuzhenyu on 17-3-16.
 * @author tuzhenyu
 */
public class SequenceStack<E> {
    private static int defultSize = 10;
    private int top;
    private int maxSize;
    private E[] stack;

    public SequenceStack(int count){
        this.maxSize =count;
        this.top = 0;
        this.stack = (E[]) new Object[count];
    }

    public SequenceStack(){
        this(defultSize);
        this.maxSize = defultSize;
    }

    public void push(E e)throws Exception{
        if (top > maxSize)
            throw new Exception("数据溢出");
        stack[top]=e;
        top++;
    }

    public E pop()throws Exception{
        if (isEmpty())
            throw new Exception("栈为空");
        top--;
        E temp = stack[top];

        return temp;
    }

    public E getTop()throws Exception{
        if (isEmpty())
            throw new Exception("栈为空");
        return stack[--top];
    }

    public boolean isEmpty(){
        return top==0;
    }

    public int length(){
        return top;
    }

}
