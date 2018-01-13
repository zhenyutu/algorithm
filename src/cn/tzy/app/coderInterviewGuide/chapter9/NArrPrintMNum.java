package cn.tzy.app.coderInterviewGuide.chapter9;

/**
 * Created by tuzhenyu on 18-1-13.
 * @author tuzhenyu
 */
public class NArrPrintMNum {
    public void printM(int[] nums,int m){
        if (nums==null||nums.length==0||m<1)
            return;
        for (int i=0;i<m;i++){
            int index = (int)(Math.random()*(nums.length-1-m));
            System.out.println(nums[index]);
            swap(nums,index,nums.length-1-i);
        }
    }

    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        NArrPrintMNum n = new NArrPrintMNum();
        n.printM(new int[]{1,2,3,4,5,6,7,8},3);
    }
}
