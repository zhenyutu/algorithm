package cn.tzy.app.xiaozhao2017;

import java.util.Scanner;

/**
 * Created by tuzhenyu on 18-1-26.
 * @author tuzhenyu
 */
public class IsSubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int idx1=0,idx2=0;
        while (idx1<str1.length()&&idx2<str2.length()){
            if (chars1[idx1]==chars2[idx2]){
                idx2++;
            }
            idx1++;
        }
        if (idx2==str2.length())
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
