package cn.tzy.app.coderInterviewGuide.chapter3;

/**
 * Created by tuzhenyu on 17-9-11.
 * @author tuzhenyu
 */
public class BiggestSubBST {
    public TreeNode biggesSubBST(TreeNode<Integer> node){
        int[] record = new int[3];
        return postOder(node,record);
    }

    private TreeNode postOder(TreeNode<Integer> node,int[] record){
        if (node==null){
            record[0] = 0;
            record[1] = Integer.MAX_VALUE;
            record[2] = Integer.MIN_VALUE;
            return null;
        }

        int value = node.e;
        TreeNode left = node.leftNode;
        TreeNode right = node.rightNode;

        int[] param1 = new int[3];
        TreeNode lBst = postOder(left,param1);
        int[] param2 = new int[3];
        TreeNode rBst = postOder(right,param2);

        if (node==lBst&&node==rBst&&param1[2]<node.e&&param2[1]>node.e){
            record[0] = param1[0] + param2[0] +1;
            record[1] = Math.min(param1[1],node.e);
            record[2] = Math.max(param2[2],node.e);
            return node;
        }

        record[0] = Math.max(param1[0],param2[0]);
        record[1] = Math.min(Math.min(param1[1],param2[1]),node.e);
        record[2] = Math.max(Math.max(param1[2],param2[2]),node.e);

        return param1[0]>param2[0]?lBst:rBst;
    }
}
