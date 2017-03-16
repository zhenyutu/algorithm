package cn.tzy.app.dataStructure.chapter4;

/**
 * Created by tuzhenyu on 17-3-16.
 * @author tuzhenyu
 */
public interface Stack<E> {
    public void push(E e);
    public E pop();
    public int length();
    public E getTop();
    public boolean isEmpty();
}
