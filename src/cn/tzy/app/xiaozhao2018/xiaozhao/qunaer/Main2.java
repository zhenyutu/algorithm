package cn.tzy.app.xiaozhao2018.xiaozhao.qunaer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tuzhenyu on 18-4-2.
 * @author tuzhenyu
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs1 = scanner.nextLine().split(" ");
        String[] strs2 = scanner.nextLine().split(" ");

        int n = Integer.parseInt(strs1[0]);
        int target = Integer.parseInt(strs1[1]);

        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = Integer.parseInt(strs2[i]);
        }

        if (n<1){
            System.out.println("good");
            return;
        }

        if (n==1){
            if (arr[0]==target){
                System.out.println("perfect");
                return;
            }else {
                System.out.println("good");
                return;
            }
        }

        Arrays.sort(arr);

        if (arr[0]>target){
            System.out.println("good");
            return;
        }

        int start = 0;
        int end = 0;
        int sum = arr[start];

        while (end<n){
            if (sum<target){
                end++;
                if (end<n)
                    sum += arr[end];
            }else if (sum>target){
                sum -= arr[start];
                start++;
            }else {
                System.out.println("perfect");
                return;
            }
        }
        System.out.println("good");
    }
}
