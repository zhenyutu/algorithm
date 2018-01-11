package cn.tzy.app.coderInterviewGuide.chapter9;

/**
 * Created by tuzhenyu on 18-1-11.
 * @author tuzhenyu
 */
public class LeftRightMax {
    public int getMax(int[] arr){
        if (arr==null||arr.length==0)
            return 0;
        int[] lArr = new int[arr.length];
        int[] rArr = new int[arr.length];
        lArr[0] = arr[0];
        for (int i=1;i<arr.length;i++){
            lArr[i] = Math.max(lArr[i-1],arr[i]);
        }
        rArr[arr.length-1] = arr[arr.length-1];
        for (int j=arr.length-2;j>=0;j--){
            rArr[j] = Math.max(rArr[j+1],arr[j]);
        }
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            max = Math.max(max,lArr[i]-rArr[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        LeftRightMax l = new LeftRightMax();
        System.out.println(l.getMax(new int[]{2,7,3,1,1}));
    }
}
