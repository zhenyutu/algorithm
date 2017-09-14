package cn.tzy.app.coderInterviewGuide.chapter3;

/**
 * Created by tuzhenyu on 17-9-14.
 * @author tuzhenyu
 */
public class CheckStruct {
    public boolean contains(TreeNode node1,TreeNode node2){
        return check(node1,node2)||contains(node1.leftNode,node2)||check(node1.rightNode,node2);
    }

    private boolean check(TreeNode node1,TreeNode node2){
        if (node2==null)
            return true;
        if (node1==null||node1.e!=node2.e){
            return false;
        }

        return check(node1.leftNode,node2.leftNode)&&check(node1.rightNode,node2.rightNode);
    }
}
