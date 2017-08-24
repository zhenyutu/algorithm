package cn.tzy.app.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-21.
 * @author tuzhenyu
 * leetcode_385  WIP
 */
class NestedInteger{
    private int val;
    NestedInteger(int val){
        this.val = val;
    }
    NestedInteger(){}

    public void add(NestedInteger ni){}
    public boolean isInteger(){ return true;}
    public Integer getInteger(){return 1;}
    public List<NestedInteger> getList(){return new ArrayList<>();}
}
public class MiniParser {
    public NestedInteger deserialize(String s) {
        if (s==null)
            return null;
        if (s.charAt(0)!='[')
            return new NestedInteger(Integer.parseInt(s));

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger res = new NestedInteger();
        stack.push(res);
        int state = 1;
        for (int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if (c=='['){
                NestedInteger ni = new NestedInteger();
                stack.peek().add(ni);
                stack.push(ni);
                state = i+1;
            }else if (c==','||c==']'){
                if (i>state){
                    int val = Integer.parseInt(s.substring(state,i));
                    stack.peek().add(new NestedInteger(val));
                }
                state = i+1;
                if (c==']'){
                    stack.pop();
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String str = "[123,[456,[789]]]";
    }
}
