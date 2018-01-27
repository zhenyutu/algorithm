package cn.tzy.app.coderInterviewGuide.chapter9;

/**
 * Created by tuzhenyu on 18-1-27.
 * @author tuzhenyu
 */
public class StringAssociation {
    public void association(String str){
        if (str==null||str.length()==0)
            return;
        int len = str.length();
        int n = 1<<len;
        for (int i=1;i<n;i++){
            StringBuffer sb = new StringBuffer();
            for (int j=0;j<len;j++){
                if ((i&(1<<j))!=0){
                    sb.append(str.charAt(j));
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        StringAssociation s = new StringAssociation();
        s.association("123");
    }
}
