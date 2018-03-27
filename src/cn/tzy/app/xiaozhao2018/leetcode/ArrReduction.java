package cn.tzy.app.xiaozhao2018.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tuzhenyu on 18-1-26.
 * @author tuzhenyu
 */
public class ArrReduction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] num = new int[n+1];
        int[] arr = new int[n+1];
        for (int i=1;i<=n;i++){
            int tmp = scanner.nextInt();
            arr[i] = tmp;
            num[tmp] = 1;
        }

        List<Integer> list = new ArrayList<>();
        for (int i=1;i<=n;i++){
            if (num[i]==0){
                list.add(i);
            }
        }

        List<List<Integer>> lists = new ArrayList<>();
        perm(lists,list,list.size()-1,0);

        System.out.println("");

    }

    private static void perm(List<List<Integer>> lists,List<Integer> list,int n,int k){
        if (n==k){
            lists.add(new ArrayList<>(list));
        }else {
            for (int i=k;k<=n;i++){
                Collections.swap(list,i,k);
                perm(lists,list,n,k+1);
                Collections.swap(list,i,k);
            }
        }
    }
}
