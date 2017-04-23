package cn.tzy.app.algorithm.chapter3;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by tuzhenyu on 17-4-23.
 * @author tuzhenyu
 */
public class RedBlackBST<T extends Comparable<T>,V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    class Node{
        private T t;
        private V v;
        private Node left,right;
        boolean color;

        public Node(T t,V v,boolean color){
            this.t = t;
            this.v = v;
            this.color = color;
        }
    }

    private boolean isRed(Node node){
        if (node == null)
            return false;
        return node.color == RED;
    }

    private Node rotateLeft(Node node){
        Node s = node.right;
        node.right = s.left;
        s.left = node;
        s.color = node.color;
        node.color = RED;
        return s;
    }

    private Node rotateRight(Node node){
        Node s = node.left;
        node.left = s.right;
        s.right = node;
        s.color = node.color;
        node.color = RED;
        return s;
    }

    private void flipColor(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void put(T t,V v){
        root = put(root,t,v);
    }

    private Node put(Node node,T t,V v){
        if (node==null)
            return new Node(t,v,RED);
        int cmp = t.compareTo(node.t);
        if (cmp>0)
            node.right = put(node.right,t,v);
        else if (cmp<0)
            node.left = put(node.left,t,v);
        else
            node.t = t;
        if (isRed(node.right)&&!isRed(node.left))
            node = rotateLeft(node);
        if(isRed(node.left)&&isRed(node.left.left))
            node = rotateRight(node);
        if (isRed(node.left)&&isRed(node.right))
            flipColor(node);

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
}
