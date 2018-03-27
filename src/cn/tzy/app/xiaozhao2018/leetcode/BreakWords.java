package cn.tzy.app.xiaozhao2018.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tuzhenyu on 18-3-25.
 * @author tuzhenyu
 */
public class BreakWords {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        if (s==null||s.length()==0||dict.size()==0)
            return res;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i=0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
                if (dict.contains(s.substring(i,j+1)))
                    dp[i][j] = true;
            }
        }
        search(dp,0,s,new String(""),res);
        return res;
    }

    private void search(boolean[][] dp,int index,String s,String str,ArrayList<String> res){
        if (index==s.length()) {
            res.add(str.substring(1,str.length()));
            return;
        }
        for (int i=index;i<s.length();i++){
            if (dp[index][i]){
                String tmp = str+" "+s.substring(index,i+1);
                search(dp,i+1,s,tmp,res);
            }
        }
    }

    public static void main(String[] args) {
        BreakWords b = new BreakWords();
        Set<String> set = new HashSet<>();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        System.out.println(b.wordBreak("catsanddog",set));
    }
}
