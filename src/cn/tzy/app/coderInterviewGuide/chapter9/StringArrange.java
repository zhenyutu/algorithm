package cn.tzy.app.coderInterviewGuide.chapter9;

/**
 * Created by tuzhenyu on 18-1-27.
 * @author tuzhenyu
 */
public class StringArrange {
    public void arrage(String str){
        if (str==null||str.length()==0)
            return;
        char[] chars = str.toCharArray();
        exchange(chars,str.length()-1,0);
    }
    private void exchange(char[] chars,int n,int k){
        if (k==n){
            System.out.println(new String(chars));
        }else {
            for (int i=k;i<=n;i++){
                swap(chars,k,i);
                exchange(chars,n,k+1);
                swap(chars,k,i);
            }
        }
    }

    private void swap(char[] chars,int i,int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        StringArrange s = new StringArrange();
        s.arrage("12345");
    }
}
