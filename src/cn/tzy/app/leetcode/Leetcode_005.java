package cn.tzy.app.leetcode;


import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-4-10.
 * @author tuzhenyu
 */
public class Leetcode_005 {
    public static String longestPalindrome(String s) {
        String result = ""+s.charAt(0);
        int ans = 1;
        for (int i=0;i<s.length()-1;i++){
            for (int j=i+1;j<s.length();j++){
                String sub = s.substring(i,j+1);
                String tmp = new StringBuffer(sub).reverse().toString();
                ans = sub.length();
                if (ans>1&&sub.equals(tmp)){
                    result = (ans>result.length())?sub:result;
                }
            }
        }
        return result;
    }
    public static String longestPalindromeUp(String s) {
        String result = ""+s.charAt(0);
        char[] arr = s.toCharArray();
        int ans = 1;
        for (int i=0;i<s.length()-1;i++){
            if (arr[i]==arr[i+1]){
                for (int j=1;j<s.length();j++){
                    if (i-j>=0&&i+1+j<s.length()-1&&arr[i-j]==arr[i+1+j]){
                        String sub = s.substring(i-j,i+j+2);
                        ans = sub.length();
                        result = (ans>result.length())?sub:result;
                    }else{
                        String sub = s.substring(i,i+2);
                        result = (2>result.length())?sub:result;
                        break;
                    }
                }
            }else if (arr[i]==arr[i-1]){
                for (int j=1;j<s.length()/2;j++){
                    if (i-1-j>=0&&i+j<s.length()-1&&arr[i-1-j]==arr[i+j]){
                        String sub = s.substring(i-1-j,i+j+1);
                        ans = sub.length();
                        result = (ans>result.length())?sub:result;
                    }else{
                        String sub = s.substring(i-1,i+1);
                        result = (2>result.length())?sub:result;
                        break;
                    }
                }
            }else {
                for (int j=1;j<s.length()/2;j++){
                    if (i-j>=0&&i+j<s.length()-1&&arr[i-j]==arr[i+j]){
                        String sub = s.substring(i-j,i+j+1);
                        ans = sub.length();
                        result = (ans>result.length())?sub:result;
                    }else{
                        break;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));
        System.out.println(longestPalindromeUp(str));
    }
}
