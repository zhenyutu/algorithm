package cn.tzy.app.swordoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 17-10-28.
 * @author tuzhenyu
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre==null || in==null)
            return null;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        return construct(pre,0,pre.length-1,in,0,in.length-1,map);
    }

    private TreeNode construct(int[] pre,int pi,int pj,int[] in,int ni,int nj,Map<Integer,Integer> map){
        if (pi>pj)
            return null;
        TreeNode node = new TreeNode(pre[pi]);
        int index = map.get(pre[pi]);
        node.left = construct(pre,pi+1,pi+index-ni,in,ni,index-1,map);
        node.right = construct(pre,pi+index-ni,pj,in,index,nj,map);
        return node;
    }
}


