package cn.tzy.app.algorithm.chapter3;

/**
 * Created by tuzhenyu on 17-4-19.
 * @author tuzhenyu
 */
public class BST<T extends Comparable<T>,V> {
    private Node root;
    class Node{
        private T t;
        private V v;
        private Node left,right;
        private int N;

        public Node(T t,V v,int N){
            this.t = t;
            this.v = v;
            this.N = N;
        }
    }

    public int size(Node node){
        return node.N;
    }

    public int size(){
        return size(root);
    }

    public void put(T t,V v){
        root = put(root,t,v);
    }

    private Node put(Node node,T t,V v){
        if (node == null){
            return new Node(t,v,1);
        }
        int cmp = t.compareTo(node.t);
        if (cmp>0){
            node.right = put(node.right,t,v);
        }else if (cmp<0){
            node.left = put(node.left,t,v);
        }else {
            node.v = v;
        }
        node.N = size(node.left)+ size(node.right) + 1;
        return node;
    }

    public V get(T t){
        return get(root,t);
    }

    private V get(Node node,T t){
        if (t == null)
            return null;
        int cmp = t.compareTo(node.t);
        if (cmp > 0) {
            return get(node.right,t);
        }else if(cmp<0){
            return get(node.left,t);
        }else {
            return node.v;
        }
    }

    public V min(){
        return min(root).v;
    }

    private Node min(Node node){
        if (node.left == null)
            return node;
        return min(node.left);
    }

    public void deleteMin(){
        deleteMin(root);
    }

    private Node deleteMin(Node node){
        if (node.left == null)
            return node.right;
        else
            node.left = deleteMin(node.left);
        return node;
    }

    private Node delete(Node node,T t){
        if (node == null)
            return null;
        int cmp = t.compareTo(node.t);
        if (cmp>0)
            return node.right = delete(node.right,t);
        else if (cmp<0)
            return node.left = delete(node.left,t);
        else {
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;
            Node tmp = node;
            node = min(tmp.right);
            node.right = deleteMin(tmp.right);
            node.left = tmp.left;
        }
        return node;
    }
}
