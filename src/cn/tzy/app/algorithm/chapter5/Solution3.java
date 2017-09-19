package cn.tzy.app.algorithm.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by tuzhenyu on 17-9-18.
 */
public class Solution3 {
    private void convert(String str){
        ArrayList<String> result = new ArrayList<>();
        StringBuffer sb0 = new StringBuffer();
        for (int p=0;p<str.length();p++){
            char c = (char)('a'+ str.charAt(p)-'1');
            sb0.append(c);
        }
        result.add(sb0.toString());
        for (int i=0;i<str.length();i++){
            for (int j=i+1;j<str.length();j++){
                String subStr = str.substring(i,j+1);
                String preStr = str.substring(0,i);
                String postStr = str.substring(j+1,str.length());
                int subInt = Integer.parseInt(subStr);
                if (subInt<26){
                    StringBuffer sb = new StringBuffer();
                    if (!"".equals(preStr)){
                        for (int k=0;k<preStr.length();k++){
                            char c = (char)('a'+ preStr.charAt(k)-'1');
                            sb.append(c);
                        }
                    }
                    sb.append((char)('a'+subInt-1));
                    if (!"".equals(postStr)){
                        for (int k=0;k<postStr.length();k++){
                            char c = (char)('a'+ postStr.charAt(k)-'1');
                            sb.append(c);
                        }
                    }
                    result.add(sb.toString());
                }
            }
        }

        Collections.sort(result);
        for (int q=0;q<result.size()-1;q++){
            System.out.print(result.get(q)+" ");
        }
        System.out.print(result.get(result.size()-1));
    }

    public void convertStr(){
        ArrayList<String> arr = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        while (nextLine != null && !nextLine.equals("")) {
            arr.add(nextLine);
            nextLine = scanner.nextLine();
        }

        for (String str : arr){
            convert(str);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String str = "1234";
//        convert(str);
        Solution3 solution3 = new Solution3();
        solution3.convertStr();
    }
}
