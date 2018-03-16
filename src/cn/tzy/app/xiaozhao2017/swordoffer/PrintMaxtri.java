package cn.tzy.app.xiaozhao2017.swordoffer;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class PrintMaxtri {
    public void print(int[][] maxtri){
        if (maxtri==null||maxtri.length==0||maxtri[0].length==0)
            return;

        int tr = 0,tb = 0;
        int bt = maxtri.length-1,bl = maxtri[0].length-1;

        while (tr<=bl&&tb<=bt){
            if (tr==bl){
                for (int i=tb;i<=bt;i++){
                    System.out.println(maxtri[i][tr]);
                }
            }else if (tb==bt){
                for (int i=tr;i<=bl;i++){
                    System.out.println(maxtri[tb][i]);
                }
            }else {
                for (int i=tr;i<bl;i++){
                    System.out.println(maxtri[i][tb]);
                }
                for (int j=tb;j<bt;j++){
                    System.out.println(maxtri[j][bl]);
                }
                for (int p=bl;p>0;p--){
                    System.out.println(maxtri[bt][p]);
                }
                for (int q=bt;q>0;q--){
                    System.out.println(maxtri[q][tr]);
                }
            }
        }
    }
}
