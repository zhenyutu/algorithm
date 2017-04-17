package cn.tzy.app.algorithm.chapter2;

/**
 * Created by tuzhenyu on 17-4-16.
 * @author tuzhenyu
 */
public class MinPQ<T extends Comparable<T>> {
    private T[] pq;
    private int N = 0;

    public MinPQ(int num){
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

    public T delMin(){
        T min = pq[1];

        exch(pq,1,N--);
        pq[N+1] = null;
        sink(1);

        return min;
    }

    private void swim(int k){
        while (k>1&&less(pq[k],pq[k/2])){
            exch(pq,k,k/2);
            k=k/2;
        }
    }

    private void sink(int k){
        while (2*k<=N){
            int j = 2*k;
            if (j<N&&less(pq[j+1],pq[j]))
                j++;
            if (!less(pq[j],pq[k]))
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
