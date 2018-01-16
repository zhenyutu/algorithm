package cn.tzy.app.coderInterviewGuide.chapter9;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 18-1-16.
 * @author tuzhenyu
 */
public class DistributeCandy {
    public int distribute(int[] score){
        if (score==null||score.length==0)
            return -1;
        int[] res = new int[score.length];
        Arrays.fill(res,1);
        for (int i=1;i<res.length;i++){
            if (score[i]>score[i-1])
                res[i] = res[i-1]+1;
        }

        for (int i=score.length-2;i>=0;i--){
            if (score[i]>score[i+1])
                res[i] = res[i+1]+1;
        }

        System.out.println(Arrays.toString(res));
        int sum = 0;
        for (int j=0;j<res.length;j++){
            sum += res[j];
        }
        return sum;
    }

    public static void main(String[] args) {
        DistributeCandy d = new DistributeCandy();
        System.out.println(d.distribute(new int[]{5,4,3,2,4}));
    }
}

