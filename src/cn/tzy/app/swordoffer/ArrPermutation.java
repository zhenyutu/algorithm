package cn.tzy.app.swordoffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tuzhenyu on 17-11-6.
 * @author tuzhenyu
 */
public class ArrPermutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str!=null&&str.length()!=0){
            permutation(str.toCharArray(),0,res);
            Collections.sort(res);
        }
        return res;
    }

    private void permutation(char[] ch,int start,ArrayList<String> res){
        if (start==ch.length-1){
            res.add(String.valueOf(ch));
        }else {
            for (int i=start;i<ch.length;++i){
                if (i==start||ch[start]!=ch[i]){
                    swap(ch,start,i);
                    permutation(ch,i+1,res);
                    swap(ch,start,i);
                }
            }
        }
    }

    private void swap(char[] ch,int i,int j){
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
    }

    public static void main(String[] args) {
        ArrPermutation a= new ArrPermutation();
        System.out.println(a.Permutation("ab").toString());
    }
}
