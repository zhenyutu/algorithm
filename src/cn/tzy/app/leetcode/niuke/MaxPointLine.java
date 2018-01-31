package cn.tzy.app.leetcode.niuke;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 18-1-31.
 * @author tuzhenyu
 */
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class MaxPointLine {
    public int maxPoints(Point[] points) {
        if (points==null||points.length==0)
            return 0;
        if (points.length<3)
            return points.length;
        Map<Double,Integer> map = new HashMap<>();
        int max = 0;
        int dup = 0;
        for (int i=0;i<points.length;i++){
            map.clear();
            dup = 1;
            for (int j=0;j<points.length;j++){
                if (i == j)
                    continue;
                double scope = 0.0;
                if (points[i].x==points[j].x&&points[i].y==points[j].y){
                    dup++;
                    continue;
                }else if (points[i].x==points[j].x){
                    scope = Integer.MAX_VALUE;
                }else {
                    scope = 1.0*(points[j].y-points[i].y)/(points[j].x-points[i].x);
                }
                map.put(scope,map.containsKey(scope)?map.get(scope)+1:1);
            }
            if (map.keySet().size()==0){
                max = Math.max(max,dup);
            }else {
                for (double key : map.keySet()){
                    max = Math.max(max,map.get(key)+dup);
                }
            }

        }

        return max;
    }
}
