package cn.tzy.app.algorithm.chapter1;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by tuzhenyu on 17-3-29.
 * @author tuzhenyu
 */
public class LinkedBagTest {
    LinkedBag<Integer> bag1;
    LinkedBag<String> bag2;

    @Before
    public void init()throws Exception{
        bag1 = new LinkedBag<>();
        int [] v= {1,2,3,9,5,8};
        for(int i:v) {
            bag1.add(i);
        }

        bag2 = new LinkedBag<>();
        String [] strs = {"hello","nice","nee","you","mei","guo"};
        for(int i=0;i<strs.length;i++) {
            bag2.add(strs[i]);
        }
    }
    @Test
    public void test(){
        for (int v : bag1){
            System.out.print(v+" ");
        }
        System.out.println("");
        for (String v : bag2){
            System.out.print(v+" ");
        }

    }
}