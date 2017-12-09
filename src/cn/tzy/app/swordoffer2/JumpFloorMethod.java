package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-9.
 * @author tuzhenyu
 */
public class JumpFloorMethod {
    public int JumpFloor(int target) {
        if (target<1)
            return 0;
        else if (target==1||target==2)
            return target;
        else
            return JumpFloor(target-1)+JumpFloor(target-2);
    }
}
