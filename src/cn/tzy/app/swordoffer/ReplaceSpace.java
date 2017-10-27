package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-10-27.
 * @author tuzhenyu
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toString().toCharArray();
        for (int i=0;i<chars.length;i++){
            if (' '==chars[i]){
                sb.append("%20");
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
