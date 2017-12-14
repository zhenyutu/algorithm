package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-13.
 * @author tuzhenyu
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array==null)
            return 0;
        int tmp = array[0];
        int count = 1;
        for (int i=1;i<array.length;i++){
            if (count==0)
                tmp = array[i];
            if (array[i]==tmp)
                count++;
            else {
                count--;
            }
        }

        count = 0;
        for (int i=0;i<array.length;i++){
            if (array[i]==tmp)
                count++;
        }

        return count>array.length/2?tmp:0;
    }

    public int MoreThanHalfNum_Solution2(int [] array) {
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
}
