package cn.tzy.app.coderInterviewGuide.chapter5;

/**
 * Created by tuzhenyu on 17-10-2.
 * @author tuzhenyu
 */
public class CountStr {
    public String count(String str){
        if (str==null||str.length()==0)
            return str;
        char[] strs = str.toCharArray();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        char tmp = '$';
        for (int i=0;i<str.length();i++){
            if (tmp==strs[i]){
                num++;
            }else {
                if (num>0)
                    sb.append(tmp).append("_").append(num).append("_");
                tmp = strs[i];
                num = 1;
            }
        }
        sb.append(tmp).append("_").append(num);
        return sb.toString();
    }

    public static void main(String[] args) {
        CountStr c = new CountStr();
        System.out.println(c.count("aaabbbccd"));
    }
}
