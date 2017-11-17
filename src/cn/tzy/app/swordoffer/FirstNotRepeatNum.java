package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-17.
 * @author tuzhenyu
 */
public class FirstNotRepeatNum {
    public int FirstNotRepeatingChar(String str) {
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

    public static void main(String[] args) {
        FirstNotRepeatNum f =new FirstNotRepeatNum();
        System.out.println(f.FirstNotRepeatingChar("NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp"));
    }
}
