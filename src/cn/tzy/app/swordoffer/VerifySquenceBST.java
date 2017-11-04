package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-4.
 * @author tuzhenyu
 */
public class VerifySquenceBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null||sequence.length==0)
            return false;
        return judge(sequence,0,sequence.length-1);
    }

    private boolean judge(int[] sequence,int start,int root){
        if (start>=root)
            return true;
        int i = root-1;
        while (i>=start&&sequence[i]>sequence[root]){
            i--;
        }
        for (int j=start;j<=i;j++){
            if (sequence[j]>sequence[root])
                return false;
        }
        return judge(sequence,start,i)&&judge(sequence,i+1,root-1);
    }
}
