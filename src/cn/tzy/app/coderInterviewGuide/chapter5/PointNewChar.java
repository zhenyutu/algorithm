package cn.tzy.app.coderInterviewGuide.chapter5;

/**
 * Created by tuzhenyu on 17-10-12.
 * @author tuzhenyu
 */
public class PointNewChar {
    public String point(String str,int k){
        if (str==null||str.length()==0||k<0)
            return null;
        char[] chars = str.toCharArray();
        int num = 0;
        for (int i=k-1;i>=0;i++){
            if (chars[i]<'A'||chars[i]>'Z'){
                break;
            }
            num++;
        }

        if ((num & 1)==1)
            return str.substring(k-1,k+1);
        if (chars[k]>='A'&&chars[k]<='Z')
            return str.substring(k,k+2);

        return String.valueOf(chars[k]);
    }
}
