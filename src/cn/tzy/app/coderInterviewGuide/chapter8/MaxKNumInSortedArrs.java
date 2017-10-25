package cn.tzy.app.coderInterviewGuide.chapter8;

/**
 * Created by tuzhenyu on 17-10-25.
 * @author tuzhenyu
 */
class HeapNode{
    public int val;
    public int arrNum;
    public int index;

    public HeapNode(int val,int arrNum,int index){
        this.val = val;
        this.arrNum = arrNum;
        this.index = index;
    }
}
public class MaxKNumInSortedArrs {

    public void printTopK(int[][] maxtri,int k){
        int heapSize = maxtri.length;
        HeapNode[] heap = new HeapNode[heapSize];
        for (int i=0;i<heapSize;i++){
            int index = maxtri[i].length-1;
            heap[i] = new HeapNode(maxtri[i][index],i,index);
            heapInsert(heap,i);
        }
        System.out.println("TopK:");
        for (int j=0;j<k;j++){
            if (heapSize==0)
                break;
            System.out.print(heap[0].val+" ");
            if (heap[0].index!=0){
                heap[0].val = maxtri[heap[0].arrNum][--heap[0].index];
            }else {
                swap(heap,0,--heapSize);
            }

        }
    }

    private void heapify(HeapNode[] heap,int index,int heapSize){
        int left = index*2+1;
        int right = index*2+2;
        int large = index;
        while (left<heapSize){
            if (heap[left].val>heap[index].val){
                large = left;
            }
            if (right<heapSize&&heap[right].val>heap[index].val){
                large = right;
            }
            if (large!=index){
                swap(heap,index,large);
            }else
                break;
            index = large;
            left = index*2+1;
            right = index*2+1;
        }
    }

    private void heapInsert(HeapNode[] heap,int index){
        while (index!=0){
            int parent = (index-1)/2;
            if (heap[parent].val<heap[index].val){
                swap(heap,parent,index);
                index = parent;
            }else {
                break;
            }
        }
    }

    private void swap(HeapNode[] heap,int parent,int index){
        HeapNode tmp = heap[parent];
        heap[parent] = heap[index];
        heap[index] = tmp;
    }
}
