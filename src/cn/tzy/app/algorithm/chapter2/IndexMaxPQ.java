package cn.tzy.app.algorithm.chapter2;

/**
 * Created by tuzhenyu on 17-4-17.
 * @author tuzhenyu
 */
public class IndexMaxPQ<T extends Comparable<T>> {
    private int N=0;
    private int[] pq;
    private int[] qp;
    private T[] key;

    public IndexMaxPQ(int num){
        pq = new int[num+1];
        qp = new int[num+1];
        key = (T[])new Comparable[num+1];
        for (int i=0;i<num+1;i++){
            qp[i] = -1;
        }
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    private boolean contains(int i){
        return qp[i]!=-1;
    }

    public void insert(int i,T t){
        if (contains(i))
            throw new IllegalArgumentException("the index is already in the propriety queue");
        N++;
        qp[i] = N;
        pq[N] = i;
        key[i] = t;
        swim(N);
    }

    public int delMax(){
        int t = pq[1];
        exch(1,N--);
        sink(1);
        qp[t] = -1;
        key[pq[N+1]] = null;
        pq[N+1] = -1;

        return t;
    }

    public void delete(int i){
        exch(i,N--);
        sink(i);
        swim(i);
        key[i] = null;
        qp[i] =-1;
    }

    public void change(int i,T t){
        if (!contains(i))
            throw new IllegalArgumentException("the index is not in the propriety queue");
        key[i] = t;
        swim(qp[i]);
        sink(qp[i]);
    }

    private void swim(int k){
        while (k>1&&less(k/2,k)){
            exch(k,k/2);
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
            exch(j,k);
            k = j;
        }
    }

    private boolean less(int i,int j){
        return key[pq[i]].compareTo(key[pq[j]])<0;
    }

    private void exch(int i , int j){
       int temp = pq[i];
       pq[i] = pq[j];
       pq[j] = temp;
       qp[pq[i]] = i;
       qp[pq[j]] = j;
    }
}
