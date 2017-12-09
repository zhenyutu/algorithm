package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-9.
 * @author tuzhenyu
 */
public class RectCoverMethod {
    public int RectCover(int target) {
        if (target<1)
            return 0;
        if (target==1||target==2)
            return target;
        return RectCover(target-1)+RectCover(target-2);
    }
}
