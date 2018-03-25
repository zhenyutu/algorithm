package cn.tzy.app.xiaozhao2018.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 18-3-25.
 * @author tuzhenyu
 */
 class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
 }
public class MaxPointLIne {
    public int getMaxPoint(Point[] points){
        if (points==null||points.length==0)
            return -1;
        int max = 0;
        int dup = 1;
        Map<Double,Integer> map = new HashMap<>();
        for (int i=0;i<points.length;i++){
            map.clear();
            dup = 1;
            double scope = 0;
            for (int j=0;j<points.length;j++) {
                if (i == j)
                    continue;
                if (points[i].x == points[j].x && points[i].y == points[j].y){
                    dup++;
                }
                if (points[i].x==points[j].x)
                    scope = Integer.MAX_VALUE;
                else {
                    scope = 1.0*(points[j].y-points[i].y)/(points[j].x-points[i].x);
                }
                map.put(scope,map.containsKey(scope)?map.get(scope)+1:1);
            }

            if (map.isEmpty()){
                max = Math.max(max,dup);
            }else {
                for (double s : map.keySet()){
                    max = Math.max(max,map.get(s)+dup);
                }
            }
        }

        return max;
    }
}
