package cn.tzy.app.dataStructure.chapter3;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by tuzhenyu on 17-3-14.
 * @author tuzhenyu
 */
public class SequenceListTest {
    SequenceList list1;
    SequenceList list2;

    @Before
    public void init() throws Exception{
        list1 = new SequenceList<Integer>();
        int [] v= {1,2,3,9,5,8};
        for(int i:v) {
            list1.add(i);
        }

        list2 = new SequenceList<String>();
        String [] strs = {"hello","nice","nee you","mei guo"};
        for(String s:strs) {
            list2.add(s);
        }
    }
    @Test
    public void test() throws Exception{
        for (int i=0;i<list1.length();i++){
            System.out.print(list1.get(i)+" ");
        }
        for (int i=0;i<list2.length();i++){
            System.out.print(list2.get(i)+" ");
        }

        list1.insert(2,7);
        list1.insert(2,7);
        list2.delete(2);
        System.out.println("");

        for (int i=0;i<list1.length();i++){
            System.out.print(list1.get(i)+" ");
        }
        for (int i=0;i<list2.length();i++){
            System.out.print(list2.get(i)+" ");
        }
    }
}