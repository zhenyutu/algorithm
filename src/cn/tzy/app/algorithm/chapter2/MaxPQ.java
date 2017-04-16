package cn.tzy.app.algorithm.chapter2;

/**
 * Created by tuzhenyu on 17-4-16.
 * @author tuzhenyu
 */
public class MaxPQ<T extends Comparable<T>>{
    private T[] pq;
    private int N = 0;

    public MaxPQ(int num){
        pq = (T[])new Comparable[num+1];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void insert(T t){
        pq[++N] = t;
        swim(N);
    }

    public T delMax(){
        T max = pq[1];
        exch(pq,1,N--);
        pq[N+1] = null;
        sink(1);

        return max;
    }

    private void swim(int k){
        while (k>1&&less(k/2,k)){
            exch(pq,k,k/2);
            k=k/2;
        }
    }

    private void sink(int k){
        while (2*k<=N){
            int j = 2*k;
            if (j<N&&less(j,j+1))
                j++;
            if (!less(k,j))
                break;
            exch(pq,j,k);
            k = j;
        }
    }

    private static boolean less(Comparable v , Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a,int i , int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
