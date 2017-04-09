package cn.tzy.app.algorithm.chapter1;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Created by tuzhenyu on 17-4-9.
 * @author tuzhenyu
 */
public class WeightedUF {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedUF(int N){
        this.count = N;
        id = new int[N];
        for (int i=0;i<N;i++){
            id[i] = i;
        }
        sz = new int[N];
        for (int i=0;i<N;i++){
            sz[i] = i;
        }
    }

    public void union(int p,int q){
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);

        if (pRoot == qRoot)
            return;

        if (sz[pRoot]>sz[qRoot]){
            id[qRoot] = pRoot;
            sz[pRoot]+=qRoot;
        }else {
            id[pRoot] = qRoot;
            sz[qRoot]+=pRoot;
        }

        count--;
    }

    private int findRoot(int p){
        while (p!=id[p]){
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p,int q){
        return id[p] == id[q];
    }
}
