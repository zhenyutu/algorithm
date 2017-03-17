package cn.tzy.app.dataStructure.chapter6;

import org.junit.Test;

/**
 * Created by tuzhenyu on 17-3-17.
 * @author tuzhenyu
 */
public class BinaryTreeTest {
    @Test
    public void test(){
        Character[] str = {'A','B','C','D','E','F','G'};
        BinaryTree<Character> tree = new BinaryTree<>(str);
        tree.preOrder(tree.root);
        System.out.println("");
        tree.midOrder(tree.root);
        System.out.println("");
        tree.postOrder(tree.root);
        System.out.println("");
        tree.BFS(tree.root);
    }

}