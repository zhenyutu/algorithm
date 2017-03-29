package cn.tzy.app.algorithm.chapter1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tuzhenyu on 17-3-29.
 * @author tuzhenyu
 */
public class LinkedQueueTest {
    LinkedQueue<Integer> queue1;
    LinkedQueue<String> queue2;

    @Before
    public void init()throws Exception{
        queue1 = new LinkedQueue<>();
        int [] v= {1,2,3,9,5,8};
        for(int i:v) {
            queue1.enqueue(i);
        }

        queue2 = new LinkedQueue<>();
        String [] strs = {"hello","nice","nee","you","mei","guo"};
        for(int i=0;i<strs.length;i++) {
            queue2.enqueue(strs[i]);
        }
    }
    @Test
    public void test()throws Exception{
        for (int v : queue1){
            System.out.print(v+" ");
        }
        System.out.println("");
        while (!queue1.isEmpty()){
            System.out.print(queue1.dequeue()+" ");
        }
        System.out.println("");
        while (!queue2.isEmpty()){
            System.out.print(queue2.dequeue()+" ");
        }
    }
}