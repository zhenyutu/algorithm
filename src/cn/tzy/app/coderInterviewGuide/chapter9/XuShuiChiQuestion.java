package cn.tzy.app.coderInterviewGuide.chapter9;

/**
 * Created by tuzhenyu on 18-1-10.
 * @author tuzhenyu
 */
public class XuShuiChiQuestion {
    public int[] pick(int target,int num){
        if (num<1||target<1)
            return null;
        int[] res = new int[Math.min(target,num)];
        for (int i=0;i<res.length;i++){
            res[i] = i+1;
        }
        for (int j=target+1;j<num+1;j++){
            if (rand(j)<target){
                res[rand(target)-1] = j;
            }
        }
        return res;
    }

    private int rand(int max){
        return (int)(Math.random()*max)+1;
    }
}
