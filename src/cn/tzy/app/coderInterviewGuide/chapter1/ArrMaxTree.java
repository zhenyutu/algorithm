package cn.tzy.app.coderInterviewGuide.chapter1;

import java.util.HashMap;
import java.util.Stack;

import static cn.tzy.app.coderInterviewGuide.chapter1.ArrMaxTree.getMaxTree;

/**
 * Created by tuzhenyu on 17-7-18.
 * @author tuzhenyu
 */
public class ArrMaxTree {

    public static Node getMaxTree(int[] arr){
        HashMap<Node,Node> leftBigMap = new HashMap<>();
        HashMap<Node,Node> rightBigMap = new HashMap<>();
        Stack<Node> stack = new Stack<>();

        Node[] nodeArr = new Node[arr.length];
        for (int i=0;i<arr.length;i++){
            nodeArr[i] = new Node(arr[i]);
        }

        for (int j=0;j<nodeArr.length;j++){
            Node current = nodeArr[j];
            while (!stack.isEmpty()&&stack.peek().value<current.value){
                stack.pop();
            }
            if (stack.isEmpty())
                leftBigMap.put(current,null);
            else
                leftBigMap.put(current,stack.peek());
            stack.push(current);
        }

        for (int j=nodeArr.length-1;j>=0;j--){
            Node current = nodeArr[j];
            while (!stack.isEmpty()&&stack.peek().value<current.value){
                stack.pop();
            }
            if (stack.isEmpty())
                rightBigMap.put(current,null);
            else
                rightBigMap.put(current,stack.peek());
            stack.push(current);
        }

        Node head = null;
        for (int k=0;k<arr.length;k++){
            Node current = nodeArr[k];
            Node left = leftBigMap.get(current);
            Node right = rightBigMap.get(current);
            if (left==null&&right==null){
                head = current;
            }else if (left==null){
                if (right.left==null)
                    right.left=current;
                else
                    right.right = current;
            }else if (right==null){
                if (left.left==null)
                    left.left=current;
                else
                    left.right = current;
            }else {
                Node parent = right.value>left.value?left:right;
                if (parent.left==null)
                    parent.left=current;
                else
                    parent.right = current;
            }

        }

        return head;

    }
}

class Node{
    public int value;
    public Node left;
    public Node right;

    public Node(int value){
        this.value = value;
    }


    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        getMaxTree(arr);
    }
}
