package cn.tzy.app.algorithm.chapter3;

/**
 * Created by tuzhenyu on 17-4-19.
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
            node.N = size(node.left)+ size(right) + 1;
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
}
