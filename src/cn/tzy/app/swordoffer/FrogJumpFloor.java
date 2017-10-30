package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-10-30.
 * @author tuzhenyu
 */
public class FrogJumpFloor {
    public int JumpFloor(int target) {
        if (target<=2)
            return target;
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
}
