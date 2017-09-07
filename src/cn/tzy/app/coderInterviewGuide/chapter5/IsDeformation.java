package cn.tzy.app.coderInterviewGuide.chapter5;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 17-9-7.
 * @author tuzhenyu
 */
public class IsDeformation {
    public boolean isDeformation(String str1,String str2){
        if (str1==null||str2==null||str1.length()!=str2.length())
            return false;
        int[] map = new int[255];
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        for (int i=0;i<chars1.length;i++){
            map[chars1[i]]++;
        }
        for (int j=0;j<chars2.length;j++){
            if (map[chars2[j]]-- == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "321";
        IsDeformation is = new IsDeformation();
        System.out.println(is.isDeformation(str1,str2));
    }
}
