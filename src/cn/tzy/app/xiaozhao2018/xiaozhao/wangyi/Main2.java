package cn.tzy.app.xiaozhao2018.xiaozhao.wangyi;

import java.util.Scanner;

/**
 * Created by tuzhenyu on 18-3-27.
 * @author tuzhenyu
 */
public class Main2 {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            int n = scanner.nextInt(), k = scanner.nextInt();

            System.out.println(cal(n, k));
    }

    public static int cal(int n, int k) {
        int res = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j % i >= k)
                    res++;
            }
        }

        return res;
    }
}
