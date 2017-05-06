package cn.tzy.app.swordOffer;

/**
 * Created by tuzhenyu on 17-5-6.
 * @author tuzhenyu
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Solution019 {
    /**
     *通过递归的方法遍历整个二叉树，对比子树
     */
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean flag1 = false;
        boolean flag2 = false;
        if (root1!=null&&root2!=null){
            if (root1.val==root2.val){
                flag1 = HasSubtree(root1.left,root2.left);
                if (flag1)
                    flag1 = HasSubtree(root1.right,root2.right);
            }else {
                flag1 = HasSubtree(root1.left,root2);
                flag2 = HasSubtree(root1.right,root2);
            }
        }

        return flag1||flag2;
    }

    public static boolean HasSubtree2(TreeNode root1,TreeNode root2) {
        boolean result = false;

        if (root1!=null&&root2!=null) {
            if (root1.val == root2.val)
                result = tree1EqualTree2(root1, root2);
            if (!result)
                result = tree1EqualTree2(root1.left, root2);
            if (!result)
                result = tree1EqualTree2(root1.right, root2);
        }
        return result;
    }

    private static boolean tree1EqualTree2(TreeNode root1,TreeNode root2) {
        if (root2==null)
            return true;
        if (root1==null)
            return false;
        if (root1.val!=root2.val)
            return false;
        return tree1EqualTree2(root1.left,root2.left)&&tree1EqualTree2(root1.right,root2.right);
    }

    public static void main(String[] args) {

    }
}
