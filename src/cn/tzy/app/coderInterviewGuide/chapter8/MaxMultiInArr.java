package cn.tzy.app.coderInterviewGuide.chapter8;

/**
 * Created by tuzhenyu on 17-10-25.
 * @author tuzhenyu
 */
public class MaxMultiInArr {
    public int maxMulti(int[] arr){
        if (arr==null||arr.length==0)
            return 0;
        int max = arr[0];
        int min = arr[0];
        int maxEnd = 0;
        int minEnd = 0;
        int res = 0;
        for (int i=0;i<arr.length;i++){
            maxEnd = max * arr[i];
            minEnd = min * arr[i];
            max = Math.max(Math.max(maxEnd,minEnd),arr[i]);
            min = Math.min(Math.min(maxEnd,minEnd),arr[i]);
            res = Math.max(max,min);
        }

        return res;
    }
}
