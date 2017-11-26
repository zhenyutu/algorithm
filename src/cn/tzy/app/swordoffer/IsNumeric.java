package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-26.
 * @author tuzhenyu
 */
public class IsNumeric {
    public boolean isNumeric(char[] str) {
        try {
            double res = Double.parseDouble(new String(str));
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
