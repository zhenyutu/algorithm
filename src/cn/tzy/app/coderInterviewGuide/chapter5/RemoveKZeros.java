package cn.tzy.app.coderInterviewGuide.chapter5;

/**
 * Created by tuzhenyu on 17-9-8.
 * @author tuzhenyu
 */
public class RemoveKZeros {
    public String remove(String str, int k){
        char[] chars = str.toCharArray();
        int start = -1;
        int count = 0;
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='0'){
                count++;
                start = start==-1?i:start;

            }else {
                if (count==k){
                    while (count--!=0){
                        chars[start++] = 0;
                    }
                }
                count = 0;
                start = -1;
            }
        }
        if (count==k){
            while (count--!=0){
                chars[start++] = 0;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String str = "A0000B000";
        RemoveKZeros r = new RemoveKZeros();
        System.out.println(r.remove(str,3));
    }
}
