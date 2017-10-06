package cn.tzy.app.coderInterviewGuide.chapter5;

/**
 * Created by tuzhenyu on 17-10-6.
 * @author tuzhenyu
 */
public class StrMinDistance {
    public int minDistance(String[] strs,String str1,String str2){
        if (strs==null||strs.length==0||str1==null||str2==null)
            return -1;
        if (str1.equals(str2))
            return 0;
        int last1 = -1;
        int last2 = -1;
        int min = Integer.MIN_VALUE;
        for (int i=0;i<strs.length;i++){
            if (str1.equals(strs[i])){
                min = Math.min(min,last2==-1?min:i-last2);
                last1 = i;
            }
            if (str2.equals(strs[i])){
                min = Math.min(min,last1==-1?min:i-last1);
                last2 = i;
            }
        }
        return min==Integer.MIN_VALUE?-1:min;
    }
}
