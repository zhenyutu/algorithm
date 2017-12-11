package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-11.
 * @author tuzhenyu
 */
public class VerifySquenceOfBSTArr {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null)
            return false;
        return judge(sequence,0,sequence.length-1);
    }

    private boolean judge(int[] sequence,int start,int end){
        if (start>=end)
            return true;
        int i = end-1;
        while (i>=start&&sequence[i]>sequence[end]){
            i--;
        }
        for (int j=i;j>=start;j--){
            if (sequence[j]>sequence[end])
                return false;
        }

        return judge(sequence,start,i)&judge(sequence,i+1,end-1);
    }
}
