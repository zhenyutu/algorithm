package cn.tzy.app.swordoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by tuzhenyu on 17-11-16.
 * @author tuzhenyu
 */
public class PrintMinNumInArr {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        String res = "";
        for (int num : numbers){
            list.add(num);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1+""+o2;
                String str2 = o2+""+o1;
                return str1.compareTo(str2);
            }
        });
        for (int tmp : list){
            res+=tmp;
        }
        return res;
    }
}
