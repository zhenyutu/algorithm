package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-27.
 * @author tuzhenyu
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class NextTreeNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode==null)
            return null;
        if (pNode.right!=null){
            pNode = pNode.right;
            while (pNode.left!=null){
                pNode = pNode.left;
            }
            return pNode;
        }else {
            if (pNode.next!=null)
                return pNode.next;
        }

        return null;
    }
}
