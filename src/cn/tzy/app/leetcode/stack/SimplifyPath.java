package cn.tzy.app.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-19.
 * @author tuzhenyu
 * leetcode_71
 */
public class SimplifyPath {
    /**
     * 利用栈简化路径,时间复杂度O(n),空间复杂度O(n)
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String result = "";
        String[] paths = path.split("/");
        for (String p : paths){
            if ("..".equals(p)){
                if (!stack.isEmpty())
                    stack.pop();
            }else if (".".equals(p)||"".equals(p))
                continue;
            else
                stack.push(p);
        }
        while (!stack.isEmpty()){
            result = "/" + stack.pop() + result;
        }
        return "".equals(result)?"/":result;
    }

    public static void main(String[] args) {
        SimplifyPath s = new SimplifyPath();
//        System.out.println(s.simplifyPath("/a/./b/../../c/"));
        System.out.println(s.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
    }
}
