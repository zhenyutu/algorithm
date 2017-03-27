package cn.tzy.app.algorithm.chapter1;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.Object;

/**
 * Created by tuzhenyu on 17-3-27.
 * @author tuzhenyu
 */
public class LinkedStackTest {
    LinkedStack<Integer> stack1;
    LinkedStack<String> stack2;

    @Before
    public void init()throws Exception{
        stack1 = new LinkedStack<>();
        int [] v= {1,2,3,9,5,8};
        for(int i:v) {
            stack1.push(i);
        }

        stack2 = new LinkedStack<>();
        String [] strs = {"hello","nice","nee","you","mei","guo"};
        for(int i=0;i<strs.length;i++) {
            stack2.push(strs[i]);
        }
    }
    @Test
    public void test(){
        for (int v : stack1){
            System.out.print(v+" ");
        }
        System.out.println("");
        while (!stack1.isEmpty()){
            System.out.print(stack1.pop()+" ");
        }
        System.out.println("");
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop()+" ");
        }
    }
}