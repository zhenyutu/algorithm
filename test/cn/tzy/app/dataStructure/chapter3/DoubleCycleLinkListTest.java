package cn.tzy.app.dataStructure.chapter3;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by tuzhenyu on 17-3-15.
 * @author tuzhenyu
 */
public class DoubleCycleLinkListTest {
    DoubleCycleLinkList list1;
    DoubleCycleLinkList list2;

    @Before
    public void init() throws Exception{
        list1 = new DoubleCycleLinkList<Integer>();
        int [] v= {1,2,3,9,5,8};
        for(int i:v) {
            list1.add(i);
        }

        list2 = new DoubleCycleLinkList<Integer>();
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
//        System.out.println("");
//        list1.insert(2,7);
//        list1.insert(2,6);
//        list2.delete(0);
//
//        for (int i=0;i<list1.length();i++){
//            System.out.print(list1.get(i).getElement()+" ");
//        }
//        for (int i=0;i<list2.length();i++){
//            System.out.print(list2.get(i).getElement()+" ");
//        }
        System.out.println("");
        int count = 50;
        while (count!=0){
            list1.current = list1.current.next;
            System.out.print(list1.current.getElement()+" ");
            count--;
        }
        System.out.println("");
        count = 50;
        while (count!=0){
            System.out.print(list1.current.getElement()+" ");
            list1.current = list1.current.pre;
            count--;
        }
    }
}