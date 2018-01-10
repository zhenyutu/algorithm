package cn.tzy.app.coderInterviewGuide.chapter9;

/**
 * Created by tuzhenyu on 18-1-10.
 * @author tuzhenyu
 */
public class ZheZhiQuestion {
    public void zheZhi(int i,int N,boolean flag){
        if (i>N)
            return;
        zheZhi(i+1,N,true);
        System.out.println(flag?"top":"down");
        zheZhi(i+1,N,false);
    }
}
