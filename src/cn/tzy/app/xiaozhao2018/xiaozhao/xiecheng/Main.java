package cn.tzy.app.xiaozhao2018.xiaozhao.xiecheng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tuzhenyu on 18-3-28.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }

        int index = 0;
        int tmp;
        while (index<n){
            if (arr[index]!=0){
                tmp = index-1;
                while (tmp>=0&&arr[tmp]==0&&arr[tmp+1]!=0){
                    int t = arr[tmp];
                    arr[tmp] = arr[tmp+1];
                    arr[tmp+1] = t;

                    tmp--;
                }
            }
            index++;
        }
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
