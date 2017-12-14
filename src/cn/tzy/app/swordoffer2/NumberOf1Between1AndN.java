package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-14.
 * @author tuzhenyu
 */
public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for (int i=1;i<n+1;i++){
            sb.append(i);
        }
        String str = sb.toString();
        for (int j=0;j<str.length();j++){
            if (str.charAt(j)=='1'){
                count++;
            }
        }

        return count;
    }
}
