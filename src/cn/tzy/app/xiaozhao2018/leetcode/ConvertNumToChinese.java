package cn.tzy.app.xiaozhao2018.leetcode;

import java.util.Stack;

/**
 * Created by tuzhenyu on 18-3-28.
 * @author tuzhenyu
 */
public class ConvertNumToChinese {
    public String convert(int num){
        if (num>1000000000)
            return null;
        String[] ch = {"十","百","千","万","十万","百万","千万","亿"};
        String[] nu = {"零","一","二","三","四","五","六","七","八","九"};
        Stack<String> stack = new Stack<>();
        if (num<0)
            stack.push("负");
        num = Math.abs(num);
        int count = 0;
        while (num>0){
            int index = num%10;
            if (count==0){
                if (index==0)
                    continue;
                else {
                    stack.push(nu[index]);
                }
            }else {
                stack.push(ch[count-1]);
                stack.push(nu[index]);
            }
            num = num/10;
            count++;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ConvertNumToChinese c = new ConvertNumToChinese();
        System.out.println(c.convert(1234));
    }
}
