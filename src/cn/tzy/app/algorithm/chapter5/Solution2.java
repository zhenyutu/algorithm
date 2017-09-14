package cn.tzy.app.algorithm.chapter5;

import java.util.*;

/**
 * Created by tuzhenyu on 17-9-13.
 * @author tuzhenyu
 */
public class Solution2 {
    public void getResult(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int num = scanner.nextInt();
        String[] strs = str.split(" ");
        if (strs.length<num)
            return;
        List<String> map = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        List<String> result = new ArrayList<>();
        for (String s : strs){
            if (s.length()>3){
                String tmpStr = s.substring(1,4);
                int tmp = Integer.parseInt(tmpStr);
                list.add(tmp);
                map.add(s);
            }else {
                int tmp = Integer.parseInt(s);
                list.add(tmp);
                map.add(s);
            }
        }
        List<Integer> tmpList = new ArrayList<>(list);
        Collections.sort(list);
        for (int k : list){
            result.add(map.get(tmpList.indexOf(list.get(num-1))));

        }
        System.out.println(map.get(tmpList.indexOf(list.get(num-1))));
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.getResult();
    }
}
