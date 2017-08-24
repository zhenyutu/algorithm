package cn.tzy.app.leetcode.stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by tuzhenyu on 17-8-24.
 * @author tuzhenyu
 * leetcode_341
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i=nestedList.size()-1;i>=0;i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()){
            NestedInteger cur = stack.peek();
            if (cur.isInteger())
                return true;
            else {
                NestedInteger list = stack.pop();
                for(int i=list.getList().size()-1;i>=0;i--){
                    stack.push(list.getList().get(i));
                }
            }
        }
        return false;
    }
}
