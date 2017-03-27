package cn.tzy.app.algorithm.chapter1;

import java.io.File;
import java.util.*;

/**
 * Created by tuzhenyu on 17-3-24.
 * @author tuzhenyu
 */
public class BinarySearch {

    public static List readInts(File file){
        Scanner scanner = null;
        List<Integer> data = new ArrayList();
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()){
                data.add(scanner.nextInt());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return data;
    }

    public static boolean rank(int key,List<Integer> a){
        int start = 0;
        int end = a.size()-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if (key>a.get(mid))
                start=mid+1;
            else if (key<a.get(mid))
                end = mid-1;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List tmp = readInts(new File("/home/tuzhenyu/tmp/test.txt"));
        Collections.sort(tmp);
        System.out.println(rank(11,tmp));
        System.out.println(rank(24,tmp));
    }
}
