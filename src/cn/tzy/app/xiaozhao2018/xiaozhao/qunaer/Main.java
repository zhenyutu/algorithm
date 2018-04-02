package cn.tzy.app.xiaozhao2018.xiaozhao.qunaer;

import java.util.Scanner;

/**
 * Created by tuzhenyu on 18-4-2.
 * @author tuzhenyu
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] dict = scanner.nextLine().split(" ");

        System.out.println(dict.length/2);
    }
}
