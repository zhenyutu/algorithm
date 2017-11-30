package cn.tzy.app.swordoffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tuzhenyu on 17-11-30.
 * @author tuzhenyu
 */
public class StreamMedian {
    ArrayList<Integer> list = new ArrayList<>();
    public void Insert(Integer num) {
        list.add(num);
        Collections.sort(list);
    }

    public Double GetMedian() {
        int mid = list.size()/2;
        if (list.size()%2==0){
            int mid1 = list.get(mid-1);
            int mid2 = list.get(mid);
            double d = ((double) mid1+(double) mid2)/2;
            return d;
        }else {
            return (double)list.get(mid);
        }
    }
}
