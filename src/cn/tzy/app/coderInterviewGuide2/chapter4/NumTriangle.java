package cn.tzy.app.coderInterviewGuide2.chapter4;

/**
 * Created by tuzhenyu on 18-1-4.
 * @author tuzhenyu
 */
public class NumTriangle {
    /**
     * 暴力递归
     * @param nums
     * @return
     */
    public int maxPath(int[][] nums){
        if (nums==null||nums.length==0)
            return -1;
        return getMaxPath(nums,0,0);
    }

    private int getMaxPath(int[][] nums,int i,int j){
        if (i==nums.length-1||j==nums.length-1)
            return nums[i][j];
        int left = getMaxPath(nums,i+1,j)+nums[i][j];
        int right = getMaxPath(nums,i+1,j+1)+nums[i][j];

        return Math.max(left,right);
    }

    /**
     * 记忆搜索
     * @param nums
     * @return
     */
    public int maxPath1(int[][] nums){
        if (nums==null||nums.length==0)
            return -1;
        int[][] max = new int[nums.length][nums[0].length];
        return getMaxPath1(nums,0,0,max);
    }

    private int getMaxPath1(int[][] nums,int i,int j,int[][] max){
        if (i==nums.length-1||j==nums.length-1)
            return nums[i][j];
        int left,right;
        if (max[i+1][j]!=0)
            left = max[i+1][j]+nums[i][j];
        else
            left = getMaxPath(nums,i+1,j)+nums[i][j];

        if (max[i+1][j+1]!=0)
            right = max[i+1][j+1]+nums[i][j];
        else
            right = getMaxPath(nums,i+1,j+1)+nums[i][j];

        max[i][j] = Math.max(left,right);
        return max[i][j];
    }

    public int maxPath2(int[][] nums){
        if (nums==null||nums.length==0)
            return -1;
        int[][] cost = new int[nums.length][nums[0].length];
        for (int j=0;j<cost[cost.length-1].length;j++){
            cost[cost.length-1][j] = nums[nums.length-1][j];
        }
        for (int i=cost.length-2;i>=0;i--){
            for (int j=0;j<cost[i].length;j++){
                int right = j+1>=cost[i].length?cost[i].length-1:j+1;
                cost[i][j] = Math.max(cost[i+1][j]+nums[i][j],cost[i+1][right]+nums[i][j]);
            }
        }

        return cost[0][0];
    }

    public static void main(String[] args) {
        NumTriangle n = new NumTriangle();
        int[][] arr = new int[][]{{9,0,0,0,0},{12,15,0,0,0},{10,6,8,0,0},{2,18,9,5,0},{19,7,10,4,16}};
        System.out.println(n.maxPath2(arr));
    }
}
