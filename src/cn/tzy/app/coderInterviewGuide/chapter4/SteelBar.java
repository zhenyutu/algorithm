package cn.tzy.app.coderInterviewGuide.chapter4;

/**
 * Created by tuzhenyu on 17-9-21.
 * @author tuzhenyu
 */
public class SteelBar {
    public int maxSteelBar(int n){
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        return getMax(price,n);
    }

    private int getMax(int[] price,int n){
        if (n<=0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int i=1;i<=n;i++){
            max = Math.max(max,price[i-1]+getMax(price,n-i));
        }

        return max;
    }

    public static void main(String[] args) {
        SteelBar s = new SteelBar();
        System.out.println(s.maxSteelBar(10));
    }
}
