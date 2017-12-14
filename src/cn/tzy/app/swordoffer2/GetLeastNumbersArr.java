package cn.tzy.app.swordoffer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by tuzhenyu on 17-12-14.
 * @author tuzhenyu
 */
public class GetLeastNumbersArr {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res  =new ArrayList<>();
        if (input==null||input.length<k)
            return res;
        int[] heap = new int[k];
        for (int i=0;i<k;i++){
            insertHeap(heap,input[i],i);
        }

        for (int i=k;i<input.length;i++){
            if (input[i]<heap[0]){
                heap[0] = input[i];
                heapify(heap,0);
            }
        }

        for (int i=0;i<heap.length;i++){
            res.add(heap[i]);
        }

        return res;
    }

    private void insertHeap(int[] arr,int value,int index){
        arr[index] = value;
        while (index!=0){
            int parent = (index-1)/2;
            if (arr[parent]<arr[index]){
                swap(arr,parent,index);
                index = parent;
            }else {
                break;
            }
        }
    }

    private void heapify(int[] heap,int index){
        int left = 2*index+1;
        int right = 2*index+2;
        int largest = index;
        while (left<heap.length){
            if (heap[index]<heap[left]){
                largest = left;
            }
            if (right<heap.length&&heap[index]<heap[right]){
                largest = right;
            }
            if (largest!=index){
                swap(heap,index,largest);
            }else
                break;
            index = largest;
            left = 2*index + 1;
            right = 2*index + 2;
        }
    }

    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
