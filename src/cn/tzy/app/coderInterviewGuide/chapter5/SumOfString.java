package cn.tzy.app.coderInterviewGuide.chapter5;

/**
 * Created by tuzhenyu on 17-9-7.
 * @author tuzhenyu
 */
public class SumOfString {
    public int sumOfString(String str){
        int res = 0;
        int num = 0;
        int cur ;
        boolean negative = false;
        char[] chars = str.toCharArray();
        for (int i=0;i<chars.length;i++){
            cur = chars[i]-'0';
            if (cur<0||cur>9){
                res += num;
                num = 0;
                if (chars[i]=='-'){
                    if (i-1>-1&&chars[i-1]=='-'){
                        negative = !negative;
                    }else {
                        negative = true;
                    }
                }else {
                    negative = false;
                }
            }else {
                num = num*10+(negative?-cur:cur);
            }
        }
        res += num;
        return  res;
    }

    public static void main(String[] args) {
        String str = "A1CD-2E33";
        String str2 = "A-1B--2C--D6E";
        SumOfString s = new SumOfString();
        System.out.println(s.sumOfString(str2));
    }
}
