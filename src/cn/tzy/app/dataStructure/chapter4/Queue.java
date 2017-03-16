package cn.tzy.app.dataStructure.chapter4;

/**
 * Created by tuzhenyu on 17-3-16.
 * @author tuzhenyu
 */
public interface Queue<E> {
    public void enQueue(E e);
    public E deQueue();
    public E getFont();
    public boolean isEmpty();
}
