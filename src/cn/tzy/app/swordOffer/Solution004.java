package cn.tzy.app.swordOffer;

/**
 * Created by tuzhenyu on 17-4-26.
 * @author tuzhenyu
 */
public class Solution004 {
    /**
     *使用java的stringBuffer，额外的空间
     * 35ms 503K
     */
    public static String replaceSpace(StringBuffer str) {
        StringBuffer result = new StringBuffer("");
        for (int i=0;i<str.length();i++){
            if (' '==str.charAt(i))
                result.append("%20");
            else
                result.append(str.charAt(i));
        }
        return result.toString();
    }

    /**
     *在原数组上进行替换，不使用额外的内存空间
     * 33ms 629K
     */
    public static String replaceSpace2(StringBuffer str) {
        int numberOfOrigin = 0;
        int numberOfBlank = 0;
        int strLength = str.length();
        for (int i=0;i<strLength;i++){
            if (' '==str.charAt(i)){
                numberOfBlank++;
            }else {
                numberOfOrigin++;
            }
        }
        int newLength = numberOfBlank*3+numberOfOrigin;
        str.setLength(newLength);
        newLength--;
        for (int j=strLength-1;j>=0;j--){
            if (' '==str.charAt(j)){
                str.setCharAt(newLength--,'0');
                str.setCharAt(newLength--,'2');
                str.setCharAt(newLength--,'%');
            }else {
                str.setCharAt(newLength--,str.charAt(j));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace2(str));
    }
}
