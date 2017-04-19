package cn.tzy.app.algorithm.chapter3;

/**
 * Created by tuzhenyu on 17-4-19.
 * @author tuzhenyu
 */
public class BinarySearchST<T extends Comparable<T>,V> {
    private T[] keys;
    private V[] values;
    private int N = 0;

    public BinarySearchST(int capacity){
        this.keys = (T[])new Object[capacity];
        this.values = (V[])new Object[capacity];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int rank(T t){
        int start = 0;
        int end = N-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            int cmp = t.compareTo(keys[mid]);
            if (cmp>0)
                start=mid+1;
            else if (cmp>0)
                end = mid-1;
            else
                return mid;
        }
        return end;
    }

    public void put(T t,V v){
        int i =rank(t);
        if (i<N&&keys[i].compareTo(t)==0){
            values[i] = v;
            return;
        }
        for (int j=N;j>i;j--){
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = t;
        values[i] = v;
        N++;
    }

    public V get(T t){
        if (isEmpty())
            return null;
        int i = rank(t);
        if (i<N&&keys[i].compareTo(t)==0)
            return values[i];
        else
            return null;
    }
}
