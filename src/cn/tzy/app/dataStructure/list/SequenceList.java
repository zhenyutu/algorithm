package cn.tzy.app.dataStructure.list;

/**
 * Created by tuzhenyu on 17-3-14.
 * @author tuzhenyu
 */
public class SequenceList<E> implements List<E>{
    private static int defultSize = 10;
    private int maxSize;
    private int size;
    private E[] list;

    public SequenceList(int size){
        this.maxSize = size;
        this.size = 0;
        list = (E[])new Object[size];
    }
    public SequenceList(){
        this(defultSize);
    }

    @Override
    public void insert(E e) throws Exception{
        if (size >= maxSize)
            throw new Exception("数据溢出");
        list[size] = e;
        size++;
    }

    @Override
    public void insert(int index, E e) throws Exception{
        if (size >= maxSize)
            throw new Exception("数据溢出");
        if (index>size||index<0)
            throw new Exception("索引错误");

        for (int i=size;i>index-1;i--){
            list[i+1]=list[i];
        }
        list[index] = e;
        size++;
    }

    @Override
    public void delete(int index) throws Exception{
        if (index>size||index<0)
            throw new Exception("索引错误");
        for (int i=index;i<size;i++){
            list[i] = list[i+1];
        }
        size--;
    }

    @Override
    public E get(int index){
        return list[index];
    }

    @Override
    public int length(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        if (this.size == 0)
            return true;
        else
            return false;
    }
}
