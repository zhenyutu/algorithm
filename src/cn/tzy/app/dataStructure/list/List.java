package cn.tzy.app.dataStructure.list;

import org.omg.CORBA.Object;

/**
 * Created by tuzhenyu on 17-3-14.
 * @author tuzhenyu
 */
public interface List<E> {
    public int length();
    public boolean isEmpty();
    public void insert(E e) throws Exception;
    public void insert(int index, E e) throws Exception;
    public void delete(int index)throws Exception;
    public E get(int index);
}
