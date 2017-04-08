package cn.tzy.app.algorithm.chapter1;

/**
 * Created by tuzhenyu on 17-4-8.
 * @author tuzhenyu
 */
public class UF {
    private int[] id;
    private int count;

    public UF(int N){
        this.count = N;
        id = new int[N];
        for (int i=0;i<N;i++){
            id[i] = i;
        }
    }

    /**
     *quick-find算法的UF
     */

    public void unionQF(int p,int q){
        int pID = find(p);
        int qID = find(q);

        if (pID==qID)
            return;
        for (int i=0;i<id.length;i++){
            if (id[i] == pID)
                id[i] = qID;
        }
        count--;
    }

    /**
     *quick-union算法的UF
     */

    public void unionQN(int p,int q){
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);

        if (pRoot == qRoot)
            return;
        id[pRoot] = pRoot;

        count--;
    }

    private int findRoot(int p){
        while (p!=id[p]){
            p = id[p];
        }
        return p;
    }

    private int find(int p){
        return id[p];
    }

    public boolean connected(int p,int q){
        return id[p] == id[q];
    }
}
