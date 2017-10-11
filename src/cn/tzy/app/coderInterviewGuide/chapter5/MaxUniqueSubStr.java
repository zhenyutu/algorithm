package cn.tzy.app.coderInterviewGuide.chapter5;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-10-11.
 * @author tuzhenyu
 */
public class MaxUniqueSubStr {
    public int maxUnique(String str){
        if (str==null||str.length()==0)
            return 0;
        char[] chars = str.toCharArray();
        int[] map = new int[256];
        Arrays.fill(map,-1);
        int maxLen = 0;
        int curLen = 0;
        int pre = -1;
        for (int i=0;i<chars.length;i++){
            pre = Math.max(pre,map[chars[i]]);
            curLen = i - pre;
            maxLen = Math.max(maxLen,curLen);
            map[chars[i]] = i;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        MaxUniqueSubStr m = new MaxUniqueSubStr();
        System.out.println(m.maxUnique("aabcb"));
    }
}
