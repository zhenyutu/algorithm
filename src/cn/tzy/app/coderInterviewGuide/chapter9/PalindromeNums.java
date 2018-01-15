package cn.tzy.app.coderInterviewGuide.chapter9;

/**
 * Created by tuzhenyu on 18-1-15.
 * @author tuzhenyu
 */
public class PalindromeNums {
    public boolean isPalidrome(int num){
        if (num<0)
            num = -num;
        int tmp = 1;
        while (num/tmp>=10){
            tmp *= 10;
        }
        while (num!=0){
            if (num/tmp!=num%10)
                return false;
            num = (num%tmp)/10;
            tmp /= 100;
        }

        return true;
    }

    public boolean isPalidrome2(int num){
        String str = Math.abs(num)+"";
        int start = 0;
        int end = str.length()-1;
        while (start<end){
            if (str.charAt(start)!=str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNums p = new PalindromeNums();
        System.out.println(p.isPalidrome2(-5225));
    }
}
