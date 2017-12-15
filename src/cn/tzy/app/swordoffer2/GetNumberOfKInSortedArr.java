package cn.tzy.app.swordoffer2;

/**
 * Created by tuzhenyu on 17-12-15.
 * @author tuzhenyu
 */
public class GetNumberOfKInSortedArr {
    public int GetNumberOfK(int [] array , int k) {
        if (array==null)
            return 0;
        int left = getLeft(array,k,0,array.length-1);
        int right = getRight(array,k,0,array.length-1);

        if (left!=-1&&right!=-1)
            return right-left+1;
        return 0;
    }

    private int getLeft(int [] array , int k ,int start,int end){
        int mid = (start+end)/2;
        while (start<end){
            if (array[mid]>k){
                end = mid-1;
            }else if (array[mid]>k){
                start = mid+1;
            }else {
                if (array[mid-1]==k)
                    end = mid-1;
                else
                    return mid;
            }
            mid = (start+end)/2;
        }

        return -1;
    }

    private int getRight(int [] array , int k ,int start,int end){
        int mid = (start+end)/2;
        while (start<end){
            if(array[mid]>k){
                end = mid-1;
            }else if (array[mid]>k){
                start = mid+1;
            }else {
                if (array[mid+1]==k)
                    start = mid+1;
                else
                    return mid;
            }
            mid = (start+end)/2;
        }
        return -1;
    }
}
