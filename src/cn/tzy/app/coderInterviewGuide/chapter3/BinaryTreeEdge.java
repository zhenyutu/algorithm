package cn.tzy.app.coderInterviewGuide.chapter3;

/**
 * Created by tuzhenyu on 17-8-30.
 * @author tuzhenyu
 */
public class BinaryTreeEdge {
    public void printEdge(TreeNode head){
        if (head==null)
            return;
        int height = getHight(head,0);
        TreeNode[][] edgeMap = new TreeNode[height][2];
        for (int i =0;i<edgeMap.length;i++){
            System.out.print(edgeMap[i][0]+" ");
        }
        printLeafNotInMap(head,0,edgeMap);
        for (int i = edgeMap.length - 1; i != -1; i--) {
            if (edgeMap[i][0] != edgeMap [i][1]) {
                System.out.println(edgeMap[i][1].e + "");
            }
        }

    }

    private int getHight(TreeNode root,int h){
        if (root == null)
            return h;
        return Math.max(getHight(root.leftNode,h+1),getHight(root.rightNode,h+1));
    }

    public static void setEdgeMap(TreeNode h,int l,TreeNode[][] edgeMap) {
        if (h == null) {
            return;
        }
        edgeMap[l][0] = edgeMap[l][0] == null ? h : edgeMap[l][0];
        edgeMap[l][1] = h;
        setEdgeMap(h.leftNode, l+1, edgeMap);
        setEdgeMap(h.leftNode, l+1, edgeMap);
    }

    public static void printLeafNotInMap(TreeNode h, int l, TreeNode[][] m) {
        if (h == null) {
            return;
        }
        if (h.leftNode == null && h.rightNode== null && h != m[l][0] && h != m[l][1]) {
            System.out.println(h.e+" ");
        }
        printLeafNotInMap(h.leftNode, l + 1, m);
        printLeafNotInMap(h.rightNode, l + 1, m);
    }
}
