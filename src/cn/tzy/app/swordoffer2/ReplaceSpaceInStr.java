package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-8.
 * @author tuzhenyu
 */
public class ReplaceSpaceInStr {
    public String replaceSpace(StringBuffer str) {
        if (str==null)
            return null;
        StringBuffer sb = new StringBuffer();
        char[] chars = str.toString().toCharArray();
        for (char c : chars){
            if (c==' '){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReplaceSpaceInStr r = new ReplaceSpaceInStr();
        System.out.println(r.replaceSpace(new StringBuffer().append("We Are Happy")));
    }
}
