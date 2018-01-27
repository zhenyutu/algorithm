package cn.tzy.app.xiaozhao2017;

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
            if (arr[i]==0){
                list.add(i);
            }
        }

        List<List<Integer>> lists = new ArrayList<>();
        perm(lists,list,0);

    }

    private static void perm(List<List<Integer>> lists,List<Integer> list,int n){
        if (n==list.size()){
            lists.add(new ArrayList<>(list));
        }else {
            for (int i=n;n<list.size();i++){
                Collections.swap(list,i,n);
                perm(lists,list,n+1);
                Collections.swap(list,i,n);
            }
        }
    }
}
