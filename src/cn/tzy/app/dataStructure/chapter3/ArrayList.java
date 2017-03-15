package cn.tzy.app.dataStructure.chapter3;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by tuzhenyu on 17-3-15.
 * @author tuzhenyu
 */
public class ArrayList<E> {
    private transient Object[] elementData;
    private int size;

    public ArrayList(int initialCapacity) {
        super();
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
        this.elementData = new Object[initialCapacity]; //生成一个Object类型的数组
    }

    public ArrayList() {
        this(10); //调用ArrayList(int i),生成一个长度为１０的Object类型的数组
    }

    public ArrayList(Collection<? extends E> c) {
        elementData = c.toArray();   //返回包含此 collection 中所有元素的数组
        size = elementData.length;
        if (elementData.getClass() != Object[].class)
            elementData = Arrays.copyOf(elementData, size, Object[].class); //复制指定的数组，返回包含相同元素和长度的Object类型的数组
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))   //对象之间比较用equals
                    return i;
        }
        return -1;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int lastIndexOf(Object o) {  //最后一个对象的索引，倒着检索
        if (o == null) {
            for (int i = size-1; i >= 0; i--)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = size-1; i >= 0; i--)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    public Object clone() {     //ArrayList的clone实现的是浅拷贝，不复制这些元素本身，只是复制的是元素的引用，元素改变的话拷贝副本仍会改变
        try {
            java.util.ArrayList<?> v = (java.util.ArrayList<?>) super.clone();
//            v.elementData = Arrays.copyOf(elementData, size);
//            v.modCount = 0;
            return v;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    public boolean add(E e) {   //添加元素之前先进行扩容，然后赋值自增
//        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }

    public void add(int index, E element) {
        if (index > size || index < 0)  //如果指定要插入的数组下标超过数组容量或者指定的下标小于0，抛异常
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);

//        ensureCapacity(size+1);  // 扩大数组容量
        System.arraycopy(elementData, index, elementData, index + 1,size - index);  //从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。<br>                                                                                    // elementData --- 源数组   index --- 源数组中的起始位置   <br>                                                                                    // elementData --- 目标数组  index+1 ---  目标数组中的起始位置<br>                                                                                    // size - index --- 要复制的数组元素的数量
        elementData[index] = element; //将要添加的元素放到指定的数组下标处
        size++;
    }

    public E get(int index) {
        RangeCheck(index); //检查传入的指定下标是否合法

        return (E) elementData[index];  //返回数组下标为index的数组元素
    }

    private void RangeCheck(int index) {
        if (index >= size)  //如果传入的下标大于或等于集合的容量，抛异常
            throw new IndexOutOfBoundsException(
                    "Index: "+index+", Size: "+size);
    }

    public E remove(int index) {
        RangeCheck(index);  //检查指定的下标是否合法

//        modCount++;
        E oldValue = (E) elementData[index];  //获取指定下标的数组元素

        int numMoved = size - index - 1;  //要移动的元素个数
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index, numMoved);  //移动数组元素
        elementData[--size] = null; // Let gc do its work

        return oldValue;
    }

    public boolean remove(Object o) {
        if (o == null) { //如果传入的参数为null
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {  //移除首次出现的null
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    private void fastRemove(int index) {  //移除指定位置的元素,实现方法类似remove(int i)
//        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--size] = null; // java回收机制回收内存
    }


}
