package cn.tzy.app.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by tuzhenyu on 17-5-13.
 * @author tuzhenyu
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

//        for (int i : list){
//            list.add(0);
//            System.out.println(i);
//        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next()==3)
                iterator.remove();
//            System.out.println(iterator.next());
        }
        System.out.println(list.toString());
        ConcurrentHashMap
    }
}
