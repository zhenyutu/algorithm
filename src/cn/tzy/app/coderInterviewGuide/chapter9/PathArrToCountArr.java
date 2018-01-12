package cn.tzy.app.coderInterviewGuide.chapter9;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 18-1-12.
 * @author tuzhenyu
 */
public class PathArrToCountArr {
    public int[] convert(int[] path){
        if (path==null||path.length==0)
            return null;
        int[] res = new int[path.length];
        for(int i=0;i<path.length;i++){
            if (res[i]==0){
                jump(path,res,i);
            }
        }

        return res;
    }

    private int jump(int[] path,int[] res,int next){
        if (path[next] == next){
            res[next] = 1;
            return res[next];
        }
        res[next] = jump(path,res,path[next])+1;
        return res[next];
    }

    public static void main(String[] args) {
        PathArrToCountArr p = new PathArrToCountArr();
        int[] res = p.convert(new int[]{9,1,4,9,0,4,8,9,0,1});
        System.out.println(Arrays.toString(res));
    }
}
