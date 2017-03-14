package cn.tzy.app.dataStructure.chapter3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tuzhenyu on 17-3-14.
 * @author tuzhenyu
 */
public class SingleLinkListTest {
    SingleLinkList list1;
    SingleLinkList list2;

    @Before
    public void init() throws Exception{
        list1 = new SingleLinkList<Integer>();
        int [] v= {1,2,3,9,5,8};
        for(int i:v) {
            list1.add(i);
        }

        list2 = new SingleLinkList<String>();
        String [] strs = {"hello","nice","nee","you","mei","guo"};
        for(String s:strs) {
            list2.add(s);
        }
    }

    @Test
    public void test() throws Exception{
        for (int i=0;i<list1.length();i++){
            System.out.print(list1.get(i).getElement()+" ");
        }
        for (int i=0;i<list2.length();i++){
            System.out.print(list2.get(i).getElement()+" ");
        }
        System.out.println("");
        list1.insert(2,7);
        list1.insert(2,7);
        list2.delete(2);

        for (int i=0;i<list1.length();i++){
            System.out.print(list1.get(i).getElement()+" ");
        }
        for (int i=0;i<list2.length();i++){
            System.out.print(list2.get(i).getElement()+" ");
        }

        System.out.println("");
        while (list1.first!=null){
            System.out.print(list1.first.getElement()+" ");
            list1.first = list1.first.next;
        }
    }

}