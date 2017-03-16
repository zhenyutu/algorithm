package cn.tzy.app.dataStructure.chapter4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tuzhenyu on 17-3-16.
 * @author tuzhenyu
 */
public class SequenceStackTest {
    SequenceStack stack1;
    SequenceStack stack2;

    @Before
    public void init()throws Exception{
        stack1 = new SequenceStack(15);
        int [] v= {1,2,3,9,5,8};
        for(int i:v) {
            stack1.push(i);
        }

        stack2 = new SequenceStack();
        String [] strs = {"hello","nice","nee","you","mei","guo"};
        for(int i=0;i<strs.length;i++) {
            stack2.push(strs[i]);
        }
    }

    @Test
    public void test()throws Exception{
        while (!stack1.isEmpty()){
            System.out.print(stack1.pop()+" ");
        }
        System.out.println("");
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop()+" ");
        }
    }
}