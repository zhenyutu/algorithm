package cn.tzy.app.coderInterviewGuide.chapter1;

import java.util.LinkedList;

/**
 * Created by tuzhenyu on 17-8-1.
 * @author tuzhenyu
 */
public class NumOfSubArr {
    public static int getNum(int[] arr,int num){
        int result = 0;
        if (arr==null||arr.length==0)
            return 0;
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();

        int i=0;
        int j=0;
        while (i<arr.length){
            while (j<arr.length){
                while (!qmin.isEmpty()&&qmin.peekLast()>=arr[j]){
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while (!qmax.isEmpty()&&qmax.peekLast()<=arr[j]){
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if (arr[qmax.getFirst()]-arr[qmin.getFirst()]>num){
                    break;
                }
                j++;
            }

            if (qmin.peekFirst()==i){
                qmin.pollFirst();
            }
            if (qmax.peekFirst()==i){
                qmax.pollFirst();
            }

            result+=j-i;
            i++;
        }


        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        System.out.println(getNum(arr,5));
    }
}
