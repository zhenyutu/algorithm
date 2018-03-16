package cn.tzy.app.xiaozhao2017.swordoffer;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class JudgePostPrint {
    public boolean judgePost(int[] post){
        if (post==null||post.length==0)
            return false;
        return judge(post,0,post.length-1);
    }

    private boolean judge(int[] post,int start,int end){
        if (start>=end)
            return true;
        int index = end-1;
        while (post[index]>post[end])
            index--;
        for (int i=index;i>=start;i--){
            if (post[i]>post[end])
                return false;
        }

        return judge(post,index+1,end-1)&judge(post,start,index);
    }
}
