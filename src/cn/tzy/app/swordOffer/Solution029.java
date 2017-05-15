package cn.tzy.app.swordOffer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tuzhenyu on 17-5-15.
 * @author tuzhenyu
 */
public class Solution029 {
    /**
     *应用递归，转换成斐波那契数列样式的求解方式
     * 未独立实现
     */
    public ArrayList<String> Permutation(String str) {
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
