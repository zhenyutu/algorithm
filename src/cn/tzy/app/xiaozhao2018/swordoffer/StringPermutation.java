package cn.tzy.app.xiaozhao2018.swordoffer;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuzhenyu on 18-3-16.
 * @author tuzhenyu
 */
public class StringPermutation {
    public List stringPermutation(String str){
        List<String> res = new ArrayList<>();
        if (str==null||str.length()==0)
            return res;
        permutation(str.toCharArray(),0,res);
        return res;
    }

    private void permutation(char[] chars,int index,List<String> list){
        if (index==chars.length-1)
            list.add(new String(chars));
        else {
            for (int i=index;i<chars.length;i++){
                swap(chars,index,i);
                permutation(chars,index+1,list);
                swap(chars,index,i);
            }
        }
    }

    private void swap(char[] chars,int start,int end){
        char tmp = chars[start];
        chars[start] = chars[end];
        chars[end] = tmp;
    }
}
