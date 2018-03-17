package cn.tzy.app.xiaozhao2018.swordoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 18-3-15.
 * @author tuzhenyu
 */
public class ReconstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre,int[] mid){
        if (pre==null||mid==null)
            return null;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<mid.length;i++){
            map.put(mid[i],i);
        }

        return construct(pre,0,pre.length-1,mid,0,mid.length,map);
    }
    private TreeNode construct(int[] pre,int preStrart,int preEnd,int[] mid,
                               int midStart,int midEnd,Map<Integer,Integer> map){
        if (preStrart>preEnd)
            return null;
        TreeNode node = new TreeNode(pre[preStrart]);
        int index = map.get(pre[preStrart]);
        node.left = construct(pre,preStrart+1,preStrart+index,mid,midStart,index-1,map);
        node.right = construct(pre,preStrart+index+1,preEnd,mid,index+1,midEnd,map);
        return node;
    }
}
