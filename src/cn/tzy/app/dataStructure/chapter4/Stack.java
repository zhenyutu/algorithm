package cn.tzy.app.dataStructure.chapter4;

/**
 * Created by tuzhenyu on 17-3-16.
 * @author tuzhenyu
 */
public interface Stack<E> {
    public void push(E e)throws Exception;
    public E pop()throws Exception;
    public int length();
    public E getTop()throws Exception;
    public boolean isEmpty();
}
