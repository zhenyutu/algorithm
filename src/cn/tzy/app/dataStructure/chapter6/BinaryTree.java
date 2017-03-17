package cn.tzy.app.dataStructure.chapter6;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tuzhenyu on 17-3-17.
 * @author tuzhenyu
 */
public class BinaryTree<E> {
    public Node<E> root = null;

    private static class Node<E>{
        E e;
        Node<E> leftNode,rightNode;

        public Node(E e){
            this.e = e;
            this.leftNode = null;
            this.rightNode = null;
        }

    }

    public BinaryTree(E[] a){
        if (root == null)
            root = new Node<>(a[0]);
        Node current = null;
        Queue<Node> nodeList = new LinkedList<>();
        nodeList.offer(root);
        int i=0;
        while (i<a.length){
            current = nodeList.poll();
            if (i*2+1 < a.length){
                current.leftNode = new Node(a[i*2+1]);
                nodeList.offer(current.leftNode);
            }
            if (i*2+2 < a.length){
                current.rightNode = new Node(a[i*2+2]);
                nodeList.offer(current.rightNode);
            }
            i++;
        }
    }

    public void preOrder(Node root){
        if (root == null)
            return;
        System.out.print(root.e+" ");
        preOrder(root.leftNode);
        preOrder(root.rightNode);
    }

    public void midOrder(Node root){
        if (root == null)
            return;
        midOrder(root.leftNode);
        System.out.print(root.e+" ");
        midOrder(root.rightNode);
    }

    public void postOrder(Node root){
        if (root == null)
            return;
        postOrder(root.leftNode);
        postOrder(root.rightNode);
        System.out.print(root.e+" ");
    }

    public void BFS(Node root){
        Queue<Node> nodeList = new LinkedList<>();
        nodeList.offer(root);
        while (!nodeList.isEmpty()){
            Node current = nodeList.poll();
            System.out.print(current.e+" ");
            if (current.leftNode != null)
                nodeList.offer(current.leftNode);
            if (current.rightNode != null)
                nodeList.offer(current.rightNode);
        }
    }
}
