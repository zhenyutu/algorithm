package cn.tzy.app.swordoffer2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 17-12-8.
 * @author tuzhenyu
 */
class TreeNode {
    int val;
    TreeNode left=null;
    TreeNode right=null;
    TreeNode(int x) { val = x; }
}

public class ReconstructBinaryTree {

    /**
     * 通过前序遍历和中序遍历重建二叉树的主要方法是通过谦虚遍历分割中序遍历数组
     * 使用HashMap保存中序遍历的位置信息，结合前序遍历获取左子树相应长度
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre==null||in==null)
            return null;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        return construct(pre,0,pre.length-1,in,0,in.length-1,map);
    }

    private TreeNode construct(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd,Map<Integer,Integer> map){
        if (preStart>preEnd)
            return null;
        TreeNode node = new TreeNode(pre[preStart]);
        int idx = map.get(pre[preStart]);
        int length = idx - inStart;
        node.left = construct(pre,preStart+1,preStart+length,in,inStart,idx-1,map);
        node.right = construct(pre,preStart+length+1,preEnd,in,idx+1,inEnd,map);
        return node;
    }
}
