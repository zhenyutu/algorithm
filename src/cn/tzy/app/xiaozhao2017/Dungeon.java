package cn.tzy.app.xiaozhao2017;

import java.util.Scanner;

/**
 * Created by tuzhenyu on 18-1-25.
 * @author tuzhenyu
 */
public class Dungeon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        boolean[][] arr = new boolean[x][y];
        for (int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                String tmp = scanner.next();
                if (tmp.equals("."))
                    arr[i][j] =true;
            }
        }

        int x0 = scanner.nextInt();
        int y0 = scanner.nextInt();

        int n = scanner.nextInt();
        int[] x_next = new int[n];
        int[] y_next = new int[n];
        for (int i=0;i<n;i++){
            x_next[i] = scanner.nextInt();
            y_next[i] = scanner.nextInt();
        }

        int[][] dp = new int[x][y];
        
    }
}
