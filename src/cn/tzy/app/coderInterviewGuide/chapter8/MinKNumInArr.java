package cn.tzy.app.coderInterviewGuide.chapter8;

/**
 * Created by tuzhenyu on 17-10-15.
 * @author tuzhenyu
 */
public class MinKNumInArr {
    public int[] getMaxNumByHeap(int[] arr,int k){
        if (arr==null||arr.length==0||k<1)
            return null;
        if (k>arr.length)
            return arr;
        int[] kHeap = new int[k];
        for (int i=0;i<k;i++){
            heapInsert(kHeap,arr[i],i);
        }

        for (int i=k;i<arr.length;i++){
            if (arr[i]<kHeap[0]){
                kHeap[0] = arr[i];
                heapify(kHeap,0,k);
            }
        }

        return kHeap;
    }

    private void heapInsert(int[] kHeap,int value,int index){
        kHeap[index] = value;
        while (index!=0){
            int parent = (index-1)/2;
            if (kHeap[parent]<kHeap[index]){
                swap(kHeap,parent,index);
                index = parent;
            }else{
                break;
            }
        }
    }

    private void heapify(int[] kHeap,int k,int heapSize){
        int left = 2*k+1;
        int right= 2*k+2;
        int largest = k;
        while (k<heapSize){
            if (kHeap[left]>kHeap[k])
                largest = left;

            if (kHeap[right]>kHeap[k])
                largest = right;

            if (largest!=k){
                swap(kHeap,largest,k);
            }else{
                break;
            }

            k = largest;
            right= 2*k+2;
            left = 2*k+1;
        }

    }

    private void swap(int[] arr,int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
