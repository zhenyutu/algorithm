package cn.tzy.app.coderInterviewGuide.chapter8;

/**
 * Created by tuzhenyu on 17-10-17.
 * @author tuzhenyu
 */
public class HalfMajor {
    public int getHalfMajor(int[] arr){
        int card = 0;
        int times = 0;
        for (int i=0;i<arr.length;i++){
            if (times==0){
                card = arr[i];
                times = 1;
            }else if (card==arr[i]){
                times++;
            }else{
                times--;
            }
        }
        times = 0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]==card)
                times++;
        }
        if (times>arr.length/2)
            return card;
        return -1;
    }
}
