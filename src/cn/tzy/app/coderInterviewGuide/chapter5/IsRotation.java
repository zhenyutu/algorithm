package cn.tzy.app.coderInterviewGuide.chapter5;

/**
 * Created by tuzhenyu on 17-9-9.
 * @author tuzhenyu
 */
public class IsRotation {
    public boolean isRotation(String a,String b){
        if (a==null||b==null||a.length()!=b.length())
            return false;
        String b2 = b+b;
        return getIndexOf(b2,a)!=-1;
    }

    private int getIndexOf(String str1,String str2){    //KMP
        return 1;
    }
}
