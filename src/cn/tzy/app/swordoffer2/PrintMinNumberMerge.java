package cn.tzy.app.swordoffer2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by tuzhenyu on 17-12-14.
 * @author tuzhenyu
 */
public class PrintMinNumberMerge {
    public String PrintMinNumber(int [] numbers) {
        if (numbers==null)
            return null;
        ArrayList<String> arr = new ArrayList<>();
        for (int i=0;i<numbers.length;i++){
            arr.add(""+numbers[i]);
        }

        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s1.compareTo(s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s: arr){
            sb.append(s);
        }
        return sb.toString();
    }

    public String PrintMinNumber2(int [] numbers) {
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
