package cn.tzy.app.coderInterviewGuide2.chapter4;

/**
 * Created by tuzhenyu on 18-1-4.
 * @author tuzhenyu
 */
public class BackPack {
    /**
     * 背包问题　重量＋价值组合
     * @param m
     * @param a
     * @param v
     * @return
     */
    public int backPack(int m,int[] a,int[] v){
        if (m<0||a==null||v==null)
            return -1;
        int[][] val = new int[a.length][m+1];
        for (int j=1;j<=m;j++){
            if (j>=a[0]&&val[0][j-a[0]]!=0){
                val[0][j] = val[0][j-a[0]]+v[0];
            }
        }

        for (int i=1;i<a.length;i++){
            for (int j=1;j<=m;j++){
                if (j>a[i]&&val[i-1][j-a[i]]+v[i]>val[i-1][j]){
                    val[i][j] = val[i-1][j-a[i]]+v[i];
                }else {
                    val[i][j] = val[i-1][j];
                }
            }
        }

        return val[a.length-1][m];
    }
}
