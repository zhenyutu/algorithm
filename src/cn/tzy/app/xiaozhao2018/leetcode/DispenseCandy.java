package cn.tzy.app.xiaozhao2018.leetcode;

/**
 * Created by tuzhenyu on 18-4-8.
 * @author tuzhenyu
 */
public class DispenseCandy {
    public int candy(int[] ratings) {
        if (ratings==null||ratings.length==0)
            return 0;
        if (ratings.length==1)
            return 1;

        int[] count = new int[ratings.length];
        int sum = 0;

        for (int i=0;i<ratings.length;i++){
            count[i] = 1;
        }
        for (int i=1;i<ratings.length;i++){
            if (ratings[i]>ratings[i-1]){
                count[i] = count[i-1] + 1;
            }
        }

        for (int j=ratings.length-2;j>=0;j--){
            if (ratings[j]>ratings[j+1]&&count[j]<=count[j+1]){
                count[j] = count[j+1]+1;
            }
            sum += count[j];
        }

        return sum+count[ratings.length-1];
    }
}
