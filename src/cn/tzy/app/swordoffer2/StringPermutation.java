package cn.tzy.app.swordoffer2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tuzhenyu on 17-12-12.
 * @author tuzhenyu
 */
public class StringPermutation {
    Set<String> list = new HashSet<>();
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str==null)
            return res;
        char[] chars = str.toCharArray();
        reOrder(chars,0);
        for (String s:list){
            res.add(s);
        }
        Collections.sort(res);
        return res;
    }

    private void reOrder(char[] chars,int index){
        if (index==chars.length-1)
            list.add(new String(chars));
        else {
            for (int i=index;i<chars.length;i++){
                swap(chars,index,i);
                reOrder(chars,index+1);
                swap(chars,index,i);
            }
        }
    }

    private void swap(char[] chars,int start,int end){
        char tmp = chars[start];
        chars[start] = chars[end];
        chars[end] = tmp;
    }

    public static void main(String[] args) {
        StringPermutation s = new StringPermutation();
        System.out.println(s.Permutation("abc").toString());
    }

    public ArrayList<String> Permutation2(String str) {
        if (str == null)
            return null;
        char[] c = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        exchange(list,c,0);
        Collections.sort(list);
        return list;
    }

    private void exchange(ArrayList<String> list,char[] c,int begin){
        if (begin==c.length&&c.length!=0){
            String s = new String(c);
            if (!list.contains(s)){
                list.add(s);
            }
        }else {
            for(int i=begin;i<c.length;i++){
                char tmp = c[i];
                c[i] = c[begin];
                c[begin] = tmp;
                exchange(list,c,begin+1);
                tmp = c[i];
                c[i] = c[begin];
                c[begin] = tmp;
            }
        }
    }
}
