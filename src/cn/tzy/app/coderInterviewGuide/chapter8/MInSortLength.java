package cn.tzy.app.coderInterviewGuide.chapter8;

/**
 * Created by tuzhenyu on 17-10-17.
 * @author tuzhenyu
 */
public class MInSortLength {
    public int getMinLength(int[] arr){
        if (arr==null||arr.length<2)
            return 0;
        int min = arr[arr.length-1];
        int minIndex = -1;
        for (int i=arr.length-2;i!=-1;i--){
            if (arr[i]>min)
                minIndex = i;
            else
                min = Math.min(min,arr[i]);
        }
        if (minIndex==-1)
            return 0;
        int max = arr[0];
        int maxIndex = -1;
        for (int i=1;i<arr.length;i++){
            if (arr[i]<max)
                maxIndex = i;
            else
                max = Math.max(max,arr[i]);
        }
        if (maxIndex==-1)
            return 0;

        return maxIndex-minIndex+1;
    }
}
