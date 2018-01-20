package cn.tzy.app.coderInterviewGuide.chapter9;

/**
 * Created by tuzhenyu on 18-1-18.
 * @author tuzhenyu
 */
public class KMP {
    public int match(String str,String tar){
        if (str==null||str.length()==0||tar==null||tar.length()==0)
            return -1;
        char[] chars = str.toCharArray();
        char[] target = tar.toCharArray();
        int i = 0;
        int j = 0;
        int[] next = getNext(tar);
        while (i<chars.length&&j<target.length){
            if (j==-1||chars[i]==target[j]){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        if (j==tar.length())
            return i-j;
        return -1;
    }

    private int[] getNext(String matcher){
        char[] chars = matcher.toCharArray();
        int[] next = new int[matcher.length()+1];
        next[0] = -1;
        int k = -1;
        for (int i=1;i<next.length;i++){
            if (k==-1||chars[i]==chars[k]){
                k++;
                next[i] = k;
            }else {
                k = next[k];
            }
        }

        return next;
    }
}
