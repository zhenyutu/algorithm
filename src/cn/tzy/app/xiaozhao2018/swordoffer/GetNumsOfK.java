package cn.tzy.app.xiaozhao2018.swordoffer;

/**
 * Created by tuzhenyu on 18-3-17.
 * @author tuzhenyu
 */
public class GetNumsOfK {
    public int getNums(int[] arr,int target){
        if (arr==null||arr.length==0)
            return 0;
        int left = getLeft(arr,target,0,arr.length-1);
        int right = getRight(arr,target,0,arr.length-1);
        return right-left+1;
    }

    private int getLeft(int[] arr,int target,int start,int end){
        int mid = (start+end)/2;
        while (start<=end){
            if (arr[mid]>target){
                end = mid-1;
            }else if(arr[mid]<target){
                start = mid+1;
            }else if (mid-1>=0&&arr[mid-1]==target){
                end = mid-1;
            }else
                return mid;
            mid = (start+end)/2;
        }

        return -1;
    }

    private int getRight(int[] arr,int target,int start,int end){
        int mid = (start+end)/2;
        while (start<=end){
            if (arr[mid]>target){
                end = mid-1;
            }else if(arr[mid]<target){
                start = mid+1;
            }else if (mid+1<arr.length&&arr[mid+1]==target){
                start = mid+1;
            }else
                return mid;
            mid = (start+end)/2;
        }

        return -1;
    }

    public static void main(String[] args) {
        GetNumsOfK g = new GetNumsOfK();
        int[] arr = new int[]{1,2,3,3,3,4,5,6,7};
        System.out.println(g.getLeft(arr,3,0,arr.length-1));
        System.out.println(g.getRight(arr,3,0,arr.length-1));
        System.out.println(g.getNums(arr,3));
    }
}
