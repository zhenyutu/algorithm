package cn.tzy.app.algorithm.chapter3;

import java.util.Random;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by tuzhenyu on 17-9-15.
 * @author tuzhenyu
 */
public class SkipLIst<E extends Comparable<? super E>> {
    private final int MAX_LEVEL;
    private final double P;
    private final SkipNode<E> header;
    private final SkipNode<E> NIL;
    private static final double OPTIMAL_P = 0.25;
    private int level = 0;

    public SkipLIst(){
        this(OPTIMAL_P,(int)Math.ceil(Math.log(Integer.MAX_VALUE) / Math.log(1 / OPTIMAL_P)) - 1);
    }

    public SkipLIst(double probability, int maxLevel){
        P = probability;
        MAX_LEVEL = maxLevel;
        header = new SkipNode<>(MAX_LEVEL,null);
        NIL = new SkipNode<>(MAX_LEVEL,null);

        for (int i=0;i<header.next.length;i++){
            header.next[i] = NIL;
        }

    }
    public boolean contain(E val){
        SkipNode<E> cur = header;
        for (int i=level;i>=0;i--){
            while (cur.next[i]!=null&&cur.next[i].val.compareTo(val)<0){
                cur = cur.next[i];
            }
            if (cur.next[i]!=null&&cur.next[i].val==val)
                return true;
        }
        return false;
    }

    public void insert(E val){
        SkipNode<E> cur = header;
        SkipNode<E>[] processors = new SkipNode[MAX_LEVEL];
        for (int i=level-1;i>=0;i--){
            while (cur.next[i].val!=null&&cur.next[i].val.compareTo(val)<0){
                cur = cur.next[i];
            }
            processors[i] = cur;
        }
        cur = cur.next[0];
        if (!val.equals(cur.val)){
            int nextLevel = randomLevel();
            if (nextLevel>level){
                for (int i=level;i<nextLevel;i++){
                    processors[i] = header;
                }
                level = nextLevel;
            }
            SkipNode<E> node = new SkipNode<E>(nextLevel,val);
            for (int j=0;j<level;j++){
                node.next[j] = processors[j].next[j];
                processors[j].next[j] = node;
            }
        }
    }

    public void delete(E val){
        SkipNode<E> cur = header;
        SkipNode<E>[] processors = new SkipNode[MAX_LEVEL];
        for (int i=level-1;i>=0;i--){
            while (cur.next[i]!=null&&cur.next[i].val.compareTo(val)<0){
                cur = cur.next[i];
            }
            processors[i] = cur;
        }
        cur = cur.next[0];
        if (cur.val==val){
            for (int i=0;i<level;i++){
                if (processors[i].next[i]!=val){
                    break;
                }
                processors[i].next[i] = cur.next[i];
            }
            while (level>0&&header.next[level-1]==NIL)
                level--;
        }
    }

    private int randomLevel(){
        int nextLevel = 1;
        while (nextLevel<MAX_LEVEL&&Math.random()<P){
            nextLevel++;
        }
        return nextLevel;
    }

    public void print() {
        for (int i = level - 1; i >= 0; i--) {
            SkipNode<E> curNode = header.next[i];
            while (curNode != NIL) {
                System.out.print(curNode.val + "->");
                curNode = curNode.next[i];
            }
            System.out.println("NIL");
        }
    }

    public static void main(String[] args) {
        SkipLIst<Integer> sl = new SkipLIst<Integer>();
        sl.insert(20);
        sl.insert(5);
        sl.insert(10);
        sl.insert(1);
        sl.insert(100);
        sl.insert(80);
        sl.insert(60);
        sl.insert(30);
        sl.print();
        System.out.println("---");
        sl.delete(20);
        sl.delete(100);
        sl.print();
    }
}

class SkipNode<E extends Comparable<? super E>>{
    public E val;
    public SkipNode<E>[] next;

    public SkipNode(int max_level,E val){
        this.val = val;
        next = new SkipNode[max_level];
    }
}
