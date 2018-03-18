package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-17.
 * @author tuzhenyu
 */
public class StringFirstAppareChar {
    public int getFirstChar(String str){
        if (str==null||str.length()==0)
            return -1;
        char[] chars = str.toCharArray();
        int[] count = new int['z'+1];
        for (int i=0;i<chars.length;i++){
            count[chars[i]]++;
        }

        for (int j=0;j<chars.length;j++){
            if (count[chars[j]]==1)
                return j;
        }

        return -1;
    }
}
