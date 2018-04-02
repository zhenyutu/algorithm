package cn.tzy.app.xiaozhao2018.xiaozhao.xiecheng;

import java.util.Scanner;

/**
 * Created by tuzhenyu on 18-3-28.
 * @author tuzhenyu
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        int[][] arr = new int[strs.length][strs.length];

        for (int i=0;i<strs.length;i++){
            arr[0][i] = Integer.parseInt(strs[i]);
        }

        for (int i=1;i<strs.length;i++){
            for (int j=0;j<strs.length;j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        int tr=0,tb=0;
        int bt=strs.length-1,bl=strs.length-1;
        while (tr<bl&&tb<bt){
            int count = bl-tr+1;
            int[] tmp = new int[bl-tr];
            for (int i=tr+1;i<=bl;i++){
                tmp[i-tr-1] = arr[tb][i];
            }

            for (int i=1;i<count;i++){
                arr[tb][tr+i] = arr[bt-i][tr];
            }
            for (int i=1;i<count;i++){
                arr[bt-i][tr] = arr[bt][bl-i];
            }
            for (int i=1;i<count;i++){
                arr[bt][bl-i] = arr[tb+i][bl];
            }
            for (int i=1;i<count;i++){
                arr[tb+i][bl] = tmp[i-1];
            }

            tr++;
            tb++;
            bl--;
            bt--;

        }

        for (int i=0;i<strs.length;i++){
            for (int j=0;j<strs.length;j++){
                System.out.print(arr[i][j]);
                if (j<strs.length-1)
                    System.out.print("  ");
            }
            System.out.println("");
        }

    }
}
