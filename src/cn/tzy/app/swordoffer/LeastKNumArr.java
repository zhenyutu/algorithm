package cn.tzy.app.swordoffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tuzhenyu on 17-11-7.
 * @author tuzhenyu
 */
public class LeastKNumArr {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input==null||input.length<k||k<=0)
            return res;
        int[] kHeap = new int[k];
        for (int i=0;i<k;i++){
            insertHeap(kHeap,input[i],i);
        }
        for (int i=k;i<input.length;i++){
            if (input[i]<kHeap[0]){
                kHeap[0] = input[i];
                heapify(kHeap,0,k);
            }
        }
        for (int j=0;j<kHeap.length;j++){
            res.add(kHeap[j]);
        }
        return  res;
    }

    private void insertHeap(int[] kHeap,int value,int index){
        kHeap[index] = value;
        while (index!=0){
            int parent = (index-1)/2;
            if (kHeap[parent]<kHeap[index]){
                swap(kHeap,index,parent);
                index = parent;
            }else {
                break;
            }
        }
    }

    private void heapify(int[] kHeap,int index ,int heapSize){
        int left = index*2+1;
        int right = index*2+2;
        int largest = index;
        while (left<heapSize){
            if (kHeap[left]>kHeap[index])
                largest = left;
            if (right<heapSize&&kHeap[right]>kHeap[index])
                largest = right;
            if (largest!=index){
                swap(kHeap,largest,index);
            }else
                break;
            index = largest;
            left = index*2+1;
            right = index*2+2;
        }
    }

    private void swap(int[] arr,int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        LeastKNumArr m = new LeastKNumArr();
        System.out.println(m.GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},0).toString());
    }
}

