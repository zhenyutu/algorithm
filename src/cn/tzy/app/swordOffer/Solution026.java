package cn.tzy.app.swordOffer;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by tuzhenyu on 17-5-11.
 * @author tuzhenyu
 */
public class Solution026 {
    /**
     * 采用前序列遍历的思想,遍历二叉树中每条路径，如果符合条件则添加list，否则则回退到山谷一个节点
     */
    private static ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<Integer> list = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null)
            return resultList;
        list.add(root.val);
        target-=root.val;
        if (target==0&&root.left==null&&root.right==null)
            resultList.add(new ArrayList<>(list));
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(FindPath(root,7).get(0).toString());
    }
}
