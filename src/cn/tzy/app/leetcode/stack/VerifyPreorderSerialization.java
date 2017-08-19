package cn.tzy.app.leetcode.stack;

import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-19.
 * @author tuzhenyu
 * leetcode_331
 */
public class VerifyPreorderSerialization {
    /**
     * 利用栈的特性检查二叉树前序遍历的正确性
     * 时间复杂度O(n) 空间复杂度O(n)
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] strs = preorder.split(",");
        for (int i=0;i<strs.length;i++){
            stack.push(strs[i]);
            while (stack.size()>2&&"#".equals(stack.get(stack.size()-1))&&"#".equals(stack.get(stack.size()-2))&&!"#".equals(stack.get(stack.size()-3))){
                stack.pop();
                stack.pop();
                stack.pop();

                stack.push("#");
            }
        }

        if (stack.size()==1&&"#".equals(stack.peek())){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        VerifyPreorderSerialization v = new VerifyPreorderSerialization();
        System.out.println(v.isValidSerialization(str));
    }
}
