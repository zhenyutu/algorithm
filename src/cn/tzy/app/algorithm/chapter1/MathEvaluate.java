package cn.tzy.app.algorithm.chapter1;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by tuzhenyu on 17-3-26.
 * @author tuzhenyu
 */
public class MathEvaluate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        ArrayDeque<Character> opsStack = new ArrayDeque();
        ArrayDeque<Double> valStack = new ArrayDeque();
        char[] arr = str.toCharArray();
        for (char s : arr){
            if ("(".equals(String.valueOf(s))){}
            else if ("+".equals(String.valueOf(s))|"-".equals(String.valueOf(s))|"*".equals(String.valueOf(s))|"/".equals(String.valueOf(s)))
                opsStack.push(s);
            else if (")".equals(String.valueOf(s))){
                Double tmp = valStack.pop();
                char ops = opsStack.pop();
                if (("+").equals(String.valueOf(ops)))
                    tmp = valStack.pop() + tmp;
                else if (("-").equals(String.valueOf(ops)))
                    tmp = valStack.pop() - tmp;
                else if (("*").equals(String.valueOf(ops)))
                    tmp = valStack.pop() * tmp;
                else if (("/").equals(String.valueOf(ops)))
                    tmp = valStack.pop() / tmp;
                valStack.push(tmp);
            }
            else
                valStack.push(Double.parseDouble(String.valueOf(s)));

        }
        System.out.println(valStack.pop());
    }
}
