package cn.tzy.app.xiaozhao2018;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by tuzhenyu on 17-12-21.
 * @author tuzhenyu
 */
public class KIndOfFood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (scanner.hasNextLine()){
            String str = scanner.nextLine();
            String[] strs = str.split(" ");
            for (String s : strs){
                set.add(s);
            }
        }

        System.out.println(set.size());
    }
}
