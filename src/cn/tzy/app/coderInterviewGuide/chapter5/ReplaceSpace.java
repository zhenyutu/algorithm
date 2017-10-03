package cn.tzy.app.coderInterviewGuide.chapter5;

import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-10-3.
 * @author tuzhenyu
 */
public class ReplaceSpace {
    public char[] repace(char[] chas){
        if (chas==null||chas.length==0)
            return chas;
        int num = 0;
        int len = 0;
        for (len=0;len<chas.length&&chas[len]!=0;len++){
            if (chas[len]==' '){
                num++;
            }
        }

        int j = len + num*2 -1;
        for (int i=len-1;i>=0;i--){
            if (chas[i]==' '){
                chas[j--] = '0';
                chas[j--] = '2';
                chas[j--] = '%';
            }else {
                chas[j--] = chas[i];
            }
        }

        return chas;
    }

    public static void main(String[] args) {
        ReplaceSpace r = new ReplaceSpace();
        char[] chas = new char[100];
        chas[0] = 'a';
        chas[1] = ' ';
        chas[2] = 'b';
        chas[3] = ' ';
        chas[4] = ' ';
        chas[5] = 'c';
        System.out.println(Arrays.toString(r.repace(chas)));
    }
}
