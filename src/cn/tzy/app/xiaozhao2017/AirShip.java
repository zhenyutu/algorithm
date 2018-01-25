package cn.tzy.app.xiaozhao2017;

import java.util.Scanner;

/**
 * Created by tuzhenyu on 18-1-25.
 * @author tuzhenyu
 */
public class AirShip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long h = scanner.nextLong();
        long tmp = (long) Math.pow(h,0.5);
        if (tmp*(tmp+1)>h){
            if (tmp*(tmp-1)>h)
                System.out.println(tmp-2);
            else
                System.out.println(tmp-1);
        }
        else
            System.out.println(tmp);
    }
}
