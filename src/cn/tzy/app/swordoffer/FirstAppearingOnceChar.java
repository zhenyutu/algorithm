package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-26.
 * @author tuzhenyu
 */
public class FirstAppearingOnceChar {
    private int[] res = new int[256];
    private StringBuffer sb = new StringBuffer();
    public void Insert(char ch)
    {
        sb.append(ch);
        res[ch]+=1;
    }
    public char FirstAppearingOnce()
    {
        for (char c : sb.toString().toCharArray()){
            if (res[c]==1)
                return c;
        }
        return '#';
    }
}
