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
        ArrayDeque<String> opsStack = new ArrayDeque();
        ArrayDeque<Double> valStack = new ArrayDeque();
        while (scanner.hasNext()){
            String s = scanner.next();
            if ("(".equals(s)){}
            else if ("+".equals(s)|"-".equals(s)|"*".equals(s)|"/".equals(s))
                opsStack.push(s);
            else if (")".equals(s)){
                Double tmp = valStack.pop();
                String ops = opsStack.pop();
                if (ops.equals("+"))
                    tmp = valStack.pop() + tmp;
                else if (ops.equals("-"))
                    tmp = valStack.pop() - tmp;
                else if (ops.equals("*"))
                    tmp = valStack.pop() * tmp;
                else if (ops.equals("/"))
                    tmp = valStack.pop() / tmp;
                valStack.push(tmp);
            }
            else
                valStack.push(Double.parseDouble(s));

            System.out.println(valStack.toString());

        }
    }
}
