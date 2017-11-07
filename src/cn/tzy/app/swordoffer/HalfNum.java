package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-7.
 * @author tuzhenyu
 */
public class HalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        int count = 1;
        int tmp = array[0];
        for (int i=1;i<array.length;i++){
            if (count==0){
                tmp = array[i];
                count++;
            }else {
                if (array[i]!=tmp)
                    count--;
                else
                    count++;
            }
        }
        count = 0;
        for (int i=0;i<array.length;i++){
            if (array[i]==tmp)
                count++;
        }

        return count>array.length/2?tmp:0;
    }

    public static void main(String[] args) {
        HalfNum h = new HalfNum();
        System.out.println(h.MoreThanHalfNum_Solution(new int[]{1,2,3,4,5}));
    }
}
