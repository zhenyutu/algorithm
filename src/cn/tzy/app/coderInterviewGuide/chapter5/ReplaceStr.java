package cn.tzy.app.coderInterviewGuide.chapter5;

/**
 * Created by tuzhenyu on 17-10-2.
 * @author tuzhenyu
 */
public class ReplaceStr {
    public String replace(String str,String from,String to){
        if (str==null||str.length()==0)
            return null;
        char[] strs = str.toCharArray();
        char[] froms = from.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean finish = false;
        int start = -1;
        int match = 0;
        for (int i=0;i<strs.length;i++){
            if (strs[i]==froms[match++]){
                start = start==-1?i:start;
                if (match==froms.length&&!finish){
                    match = 0;
                    sb.append(to);
                    finish = true;
                }
            }else {
                match=0;
                if (start!=-1){
                    for (int j=start;j<i;j++){
                        sb.append(strs[j]);
                    }
                    start = -1;
                }
                sb.append(strs[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReplaceStr r = new ReplaceStr();
        System.out.println(r.replace("123abcabc","abc","X"));
    }
}
