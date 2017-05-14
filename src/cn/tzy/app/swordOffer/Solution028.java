package cn.tzy.app.swordOffer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuzhenyu on 17-5-14.
 * @author tuzhenyu
 */
public class Solution028 {
    /**
     *利用中序列遍历将二叉查找树节点按照顺序放入列表中，再从前到后遍历列表进行指针的移动
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null)
            return null;
        List<TreeNode> list = new ArrayList<>();
        getNodeList(list,pRootOfTree);
        for (int i=0;i<list.size();i++){
            if (i-1<0)
                list.get(i).left = null;
            else
                list.get(i).left = list.get(i-1);
            if (i+1>=list.size())
                list.get(i).right = null;
            else
                list.get(i).right = list.get(i+1);
        }

        return list.get(0);
    }

    private void getNodeList(List<TreeNode> nodeList, TreeNode root){
        if (root==null)
            return;
        getNodeList(nodeList,root.left);
        nodeList.add(root);
        getNodeList(nodeList,root.right);
    }

    /**
     * 采用中序遍历，引用一个成员变量指向上一次遍历的节点，这样可以直接改变指针指向；
     */

    TreeNode pre = null;
    TreeNode head = null;

    public TreeNode Convert2(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        change(pRootOfTree);
        return head;
    }

    private void change(TreeNode root){
        if (root == null)
            return;
        change(root.left);
        if (pre == null){
            pre = root;
            head = root;
        }else {
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        change(root.right);
    }
}
