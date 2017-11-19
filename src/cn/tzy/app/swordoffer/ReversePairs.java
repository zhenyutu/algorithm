package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-18.
 */
public class ReversePairs {

    public int InversePairs(int [] array) {
        if (array==null||array.length==0)
            return 0;
        int[] copy = new int[array.length];
        for (int i=0;i<array.length;i++){
            copy[i] = array[i];
        }
        return InversePairsCore(array,copy,0,array.length);
    }

    private int InversePairsCore(int[] array,int[] copy,int low,int high){
        if (low>=high)
            return 0;
        int mid = (high+low)/2;
        int leftCOunt = InversePairsCore(array,copy,low,mid);
        int rightCOunt = InversePairsCore(array,copy,mid+1,high);
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i>=low&&j>mid){
            if (array[i]>array[j]){
                count += j-mid;
                copy[locCopy--] = array[i--];
                if (count>=1000000007)
                    count %= 1000000007;
            }else {
                copy[locCopy--] = array[j--];
            }
        }
        for (;i>=low;i--){
            copy[locCopy--] = array[i];
        }
        for (;j>mid;j--){
            copy[locCopy--] = array[j];
        }
        for (int s=low;s<=high;s++){
            array[s] = copy[s];
        }
        return (leftCOunt+rightCOunt+count)%1000000007;
    }

    /**
     * 暴力求解　时间复杂度O(n^2)
     * @param array
     * @return
     */
    public int InversePairs2(int [] array) {
        if (array==null||array.length==0)
            return 0;
        int count = 0;
        for (int i=0;i<array.length;i++){
            for (int j=i+1;j<array.length;j++){
                if (array[i]>array[j])
                    count++;
            }
        }

        return count%1000000007;
    }

    public static void main(String[] args) {
        ReversePairs r = new ReversePairs();
        System.out.println(r.InversePairs(new int[]{7,6}));
    }
}
