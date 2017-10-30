package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-10-30.
 * @author tuzhenyu
 */
public class FrogJumpFloor2 {
    public int JumpFloorII(int target) {
        if (target==0||target==1)
            return 1;
        int sum = 0;
        for (int i=0;i<target;i++){
            sum += JumpFloorII(i);
        }

        return sum;
    }
}
