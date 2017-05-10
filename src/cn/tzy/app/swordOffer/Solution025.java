package cn.tzy.app.swordOffer;

/**
 * Created by tuzhenyu on 17-5-10.
 * @author tuzhenyu
 */
public class Solution025 {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0)
            return false;
        return VerifySquenceOfSubBST(sequence,0,sequence.length-1);
    }

    private static boolean VerifySquenceOfSubBST(int [] sequence,int start,int end){
        if(start>=end)
            return true;
        int root = sequence[end];
        int mid=end;
        for (int i=start;i<=end;i++){
            if (sequence[i]>root){
                mid=i;
                break;
            }
        }
        for (int j=mid;j<=end;j++){
            if (sequence[j]<root)
                return false;
        }

        boolean left = true;
        if (mid>start)
            left = VerifySquenceOfSubBST(sequence,start,mid-1);
        boolean right = true;
        if (mid<end)
            right = VerifySquenceOfSubBST(sequence,mid+1,end);

        return (left&&right);
    }

    public static void main(String[] args) {
//        int[] sequence = {5,7,6,9,11,10,8};
//        int[] sequence = {1,2,3,4,5};
        int[] sequence = {7,4,6,5};
        System.out.println(VerifySquenceOfBST(sequence));
    }
}
