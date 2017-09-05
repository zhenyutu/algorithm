package cn.tzy.app.coderInterviewGuide.chapter3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 17-9-5.
 * @author tuzhenyu
 */
public class BinaryTreeMaxLength {
    public int getMaxLength(TreeNode<Integer> root,int sum){
        Map<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0,0);
        return preOrder(root,sum,0,1,0,sumMap);
    }

    private int preOrder(TreeNode<Integer> node,int sum,int preSum,int level,int maxLen,Map<Integer,Integer> sumMap){
        if (node==null)
            return maxLen;
        int curSum = preSum + node.e;
        if (!sumMap.containsKey(curSum))
            sumMap.put(curSum,level);
        if (sumMap.containsKey(sum-curSum))
            maxLen = Math.max(level-sumMap.get(sum-curSum),maxLen);
        maxLen = preOrder(node.leftNode,sum,curSum,level+1,maxLen,sumMap);
        maxLen = preOrder(node.rightNode,sum,curSum,level+1,maxLen,sumMap);
        if (level==sumMap.get(curSum))
            sumMap.remove(curSum);
        return maxLen;
    }
}
