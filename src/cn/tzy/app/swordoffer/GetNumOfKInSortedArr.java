package cn.tzy.app.swordoffer;

/**
 * Created by tuzhenyu on 17-11-19.
 * @author tuzhenyu
 */
public class GetNumOfKInSortedArr {
    public int GetNumberOfK(int [] array , int k) {
        if (array==null||array.length==0)
            return 0;
        int left = getLeftK(array,k,0,array.length-1);
        int right = getRightK(array,k,0,array.length-1);
        if (left!=-1&&right!=-1)
            return right-left+1;
        return 0;
    }

    private int getRightK(int[] array,int k,int start,int end){
        int mid = (start+end)>>1;
        while (start<=end){
            if (array[mid]<k)
                start = mid+1;
            else if (array[mid]>k)
                end = mid-1;
            else if (mid+1<array.length&&array[mid+1]==k){
                start = mid+1;
            }else
                return mid;
            mid = (start+end)>>1;
        }
        return -1;
    }

    private int getLeftK(int[] array,int k,int start,int end){
        int mid = (start+end)>>1;
        while (start<=end){
            if (array[mid]<k)
                start = mid+1;
            else if (array[mid]>k)
                end = mid-1;
            else if (mid-1>=0&&array[mid-1]==k){
                end = mid-1;
            }else
                return mid;
            mid = (start+end)>>1;
        }
        return -1;
    }

    public static void main(String[] args) {
        GetNumOfKInSortedArr g = new GetNumOfKInSortedArr();
        System.out.println(g.GetNumberOfK(new int[]{3,3,3,3,4,5},3));
    }
}
