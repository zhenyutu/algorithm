package cn.tzy.app.xiaozhao2018.swordoffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by tuzhenyu on 18-3-17.
 * @author tuzhenyu
 */
public class MinCombintation {
    public String getMin(String[] arr){
        if (arr==null||arr.length==0)
            return null;
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1+o2;
                String str2 = o2+o1;
                return str1.compareTo(str2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MinCombintation m = new MinCombintation();
        System.out.println(m.getMin(new String[]{"3","32","321"}));
    }
}
