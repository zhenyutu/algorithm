package cn.tzy.app.coderInterviewGuide2.chapter3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 17-12-23.
 * @author tuzhenyu
 */
public class TargetMaxLengthBT {
    public int maxLength(TreeNode<Integer> root,int target){
        if (root==null)
            return 0;
        Map<Integer,Integer> map = new HashMap<>();
        return preOrder(root,target,0,0,1,map);
    }

    private int preOrder(TreeNode<Integer> root,int target,int preSum,int maxLen
                         ,int level,Map<Integer,Integer> map){
        if (root==null)
            return maxLen;
        int curSum = preSum + root.e;
        if (!map.containsKey(curSum))
            map.put(curSum,level);
        if (map.containsKey(curSum-target))
                maxLen = Math.max(maxLen,level-map.get(curSum-target));
        maxLen = preOrder(root.leftNode,target,curSum,maxLen,level+1,map);
        maxLen = preOrder(root.rightNode,target,curSum,maxLen,level+1,map);

        if (map.get(curSum)==level)
            map.remove(curSum);
        return maxLen;
    }
}
