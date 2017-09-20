package cn.tzy.app.algorithm.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by tuzhenyu on 17-9-13.
 * @author tuzhenyu
 */
public class Solution {
    public char[] notice(int num,String str,int index,char[] res){
        int start = index<2?0:index-2;
        int end = index>num-3?num-1:index+2;
        for (int i=start;i<=end;i++){
            if (res[i]=='I')
                continue;
            if (str.charAt(i)=='c'){
                res[i] = 'I';
                res = notice(num,str,i,res);
            }else {
                res[i] = 'I';
            }
        }
        return res;
    }

    String annoncement(int numOfNeighbours,String characteristic){
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i=0;i<numOfNeighbours;i++){
            if (characteristic.charAt(i)=='c'){
                char[] r = new char[numOfNeighbours];
                Arrays.fill(r,'U');
                char[] tmp = notice(numOfNeighbours,characteristic,i,r);
                arrayList.add(String.valueOf(tmp));
            }
        }
        Collections.sort(arrayList);
        return arrayList.get(0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int num = 8;
//        String str = "nnncncnn";
        int num = 18;
        String str = "ncncncnnncnccncnnn";
        System.out.println(s.annoncement(num,str));
    }
}
