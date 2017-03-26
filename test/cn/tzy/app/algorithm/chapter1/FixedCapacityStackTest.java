package cn.tzy.app.algorithm.chapter1;

import cn.tzy.app.algorithm.FixedCapacityStack;
import org.junit.Test;

/**
 * Created by tuzhenyu on 17-3-26.
 * @author tuzhenyu
 */
public class FixedCapacityStackTest {
    private FixedCapacityStack<String> stack;
    @Test
    public void test()throws Exception{
        stack = new FixedCapacityStack<>(100);
        String [] strs = {"hello","nice","nee","you","mei","guo"};
        for(String s:strs) {
            stack.push(s);
        }

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}