package cn.tzy.app.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by tuzhenyu on 17-4-9.
 * @author tuzhenyu
 */
public class Leetcode_003 {
    public int lengthOfLongestSubstring(String s) {
        int num=0;
        Set<Character> cs = new HashSet<>();
        char[] c = s.toCharArray();
        for (int i=0;i<c.length;i++)
            cs.add(c[i]);
        System.out.println(cs.size());
        for (int i=cs.size();i>0;i--){
            for (int j=0;j<s.length()-i+1;j++){
                String str = s.substring(j,j+i);
                cs.clear();
                char[] tmp = str.toCharArray();
                for (int k=0;k<tmp.length;k++)
                    cs.add(tmp[k]);
                if (cs.size()==i){
                    num = i;
                    break;
                }
            }
            if (num!=0)
                break;
        }
        return num;
    }

    public static void main(String[] args) {
        Leetcode_003 leetcode = new Leetcode_003();
        String tmp = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ ";
        System.out.println(tmp.length());
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(leetcode.lengthOfLongestSubstring(str));
    }
}
