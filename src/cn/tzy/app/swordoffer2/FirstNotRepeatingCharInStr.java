package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-15.
 * @author tuzhenyu
 */
public class FirstNotRepeatingCharInStr {
    public int FirstNotRepeatingChar(String str) {
        if (str==null||str.length()==0)
            return -1;
        char[] chars = str.toCharArray();
        int[] count = new int['z'+1];
        for (char c : chars){
            count[c]++;
        }
        for (int i=0;i<chars.length;i++){
            if (count[chars[i]]==1)
                return i;
        }

        return -1;
    }

    public int FirstNotRepeatingChar2(String str) {
        if (str==null||str.length()==0)
            return -1;
        char[] chars = str.toCharArray();
        char[] res = new char['z'+1];
        for (char c : chars){
            res[(int)c]++;
        }
        for (int i=0;i<chars.length;i++){
            if (res[(int)chars[i]]==1)
                return i;
        }
        return -1;
    }
}
