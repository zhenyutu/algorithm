package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-21.
 * @author tuzhenyu
 */
public class SerializeBinaryTree {
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root==null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    private int index = -1;
    TreeNode Deserialize(String str) {
        index++;
        String[] strs = str.split(",");
        TreeNode node = null;
        if (!"#".equals(strs[index])){
            node = new TreeNode(Integer.parseInt(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }

        return node;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        SerializeBinaryTree s = new SerializeBinaryTree();
        System.out.println(s.Serialize(node1));
    }
}
