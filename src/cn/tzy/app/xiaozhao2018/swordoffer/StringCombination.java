package cn.tzy.app.xiaozhao2018.swordoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuzhenyu on 18-3-17.
 * @author tuzhenyu
 */
public class StringCombination {
    public List<String> combination(String str){
        List<String> res = new ArrayList<>();
        if (str==null||str.length()==0||str.length()==1)
            return res;
        int count = 1;
        for (int i=0;i<str.length();i++){
            count = count << 1;
        }

        for (int i=1;i<count;i++){
            int index = 0;
            StringBuilder sb = new StringBuilder();
            int j = i;
            while (j>0){
                if (j%2==1)
                    sb.append(str.charAt(index));
                j = j/2;
                index++;
            }
            res.add(sb.toString());
        }

        return res;
    }

    public static void main(String[] args) {
        StringCombination s = new StringCombination();
        System.out.println(s.combination("abc").toString());
    }
}
