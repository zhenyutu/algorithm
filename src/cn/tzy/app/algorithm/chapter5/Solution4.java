package cn.tzy.app.algorithm.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by tuzhenyu on 17-9-19.
 * @author tuzhenyu
 */
public class Solution4 {
//    private char[] notice(int num,String str,int index,char[] res){
//        int start = index<2?0:index-2;
//        int end = index>num-3?num-1:index+2;
//        for (int i=start;i<=end;i++){
//            if (res[i]=='I')
//                continue;
//            if (str.charAt(i)=='c'){
//                res[i] = 'I';
//                res = notice(num,str,i,res);
//            }else {
//                res[i] = 'I';
//            }
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        int num = 10;
//        String str = "nncncncnnn";
//        Solution4 s = new Solution4();
//        ArrayList<String> arrayList = new ArrayList<>();
//        for (int i=0;i<num;i++){
//            if (str.charAt(i)=='c'){
//                char[] r = new char[num];
//                Arrays.fill(r,'U');
//                char[] tmp = s.notice(num,str,i,r);
//                arrayList.add(String.valueOf(tmp));
//            }
//        }
//        Collections.sort(arrayList);
//        System.out.println(arrayList.get(0));
//    }
}
