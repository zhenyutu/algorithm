package cn.tzy.app.coderInterviewGuide.chapter4;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-9-21.
 * @author tuzhenyu
 */
public class SteelBar {
    /**
     * 暴力递归
     * @param n
     * @return
     */
    public int maxSteelBar(int n){
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        return getMax(price,n);
    }

    private int getMax(int[] price,int n){
        if (n<=0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int i=1;i<=price.length&&i<=n;i++){
            max = Math.max(max,price[i-1]+getMax(price,n-i));
        }

        return max;
    }

    /**
     * 记忆搜索
     * @param n
     * @return
     */
    public int maxSteelBar2(int n){
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int[] res = new int[n+1];
        Arrays.fill(res,-1);
        return getMax2(price,res,n);
    }

    private int getMax2(int[] price,int[] res,int n){
        if (n<=0)
            return 0;
        if (res[n]>0)
            return res[n];
        int max = Integer.MIN_VALUE;
        for (int i=1;i<=price.length&&i<=n;i++){
            max = Math.max(max,price[i-1]+getMax(price,n-i));
        }
        res[n] = max;
        return max;
    }

    public static void main(String[] args) {
        SteelBar s = new SteelBar();
        System.out.println(s.maxSteelBar2(17));
    }
}
