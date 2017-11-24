package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-24.
 * @author tuzhenyu
 */
public class DuplicateNum {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int[] res = new int[length];
        for (int i=0;i<length;i++){
            if (res[numbers[i]]==0)
                res[numbers[i]]++;
            else {
                duplication[0] = numbers[i];
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        DuplicateNum d = new DuplicateNum();
        int[] res = new int[1];
        boolean flag = d.duplicate(new int[]{2,3,1,0,2,5,3},7,res);
        System.out.println(flag);
        System.out.println(res[0]);
    }
}
