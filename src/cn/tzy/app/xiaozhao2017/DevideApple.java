package cn.tzy.app.xiaozhao2017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tuzhenyu on 18-1-25.
 * @author tuzhenyu
 */
public class DevideApple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int sum = 0;
        for (int num : arr){
            sum += num;
        }
        if (sum%n!=0) {
            System.out.println(-1);
            return;
        }
        int average = sum/n;
        int upCount = 0,downCount = 0;
        for (int num : arr){
            if (num<average){
                if ((average-num)%2!=0) {
                    System.out.println(-1);
                    return;
                }
                else
                    downCount += (average-num)/2;
            }else {
                if ((num-average)%2!=0) {
                    System.out.println(-1);
                    return;
                }
                else
                    upCount += (num-average)/2;
            }
        }
        if (upCount!=downCount) {
            System.out.println(-1);
            return;
        }
        else
            System.out.println(upCount);
    }
}
