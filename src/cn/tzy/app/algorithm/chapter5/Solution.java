package cn.tzy.app.algorithm.chapter5;

import java.util.Scanner;

/**
 * Created by tuzhenyu on 17-9-13.
 * @author tuzhenyu
 */
public class Solution {
    public void deserialize(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String numStr = String.valueOf(num);
        if (num<0){
            System.out.println(numStr.length()-1);
            System.out.print("-");
            printAbsNum(num);
            System.out.println();
            System.out.print("-");
            printReverseNum(num);

        }else {
            System.out.println(numStr.length());
            printAbsNum(num);
            System.out.println();
            printReverseNum(num);
        }
    }

    private void printAbsNum(int num){
        String absNumStr = String.valueOf(Math.abs(num));
        for (int i=0;i<absNumStr.length()-1;i++){
            System.out.print(absNumStr.charAt(i)+" ");
        }
        System.out.print(absNumStr.charAt(absNumStr.length()-1));
    }

    private void printReverseNum(int num){
        String absNumStr = String.valueOf(Math.abs(num));
        for (int i=absNumStr.length()-1;i>=0;i--){
            System.out.print(absNumStr.charAt(i));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.deserialize();
    }
}
