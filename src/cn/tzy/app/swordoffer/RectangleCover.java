package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-10-30.
 * @author tuzhenyu
 */
public class RectangleCover {
    public int RectCover(int target) {
        if (target==0||target==1||target==2)
            return target;
        return RectCover(target-1)+RectCover(target-2);
    }
}
