package others.datastructures;

import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public class MinHeap_using_Array<T> {

    public static void main(String[] args) {
        try {
            MinHeap_using_Array<Integer> heap = new MinHeap_using_Array<>(10);
            for(int i=10; i > 1; i--) {
                heap.push(i);
            }
            while(!heap.isEmpty()) {
                heap.print();
                System.out.println(heap.extractMin());
            }
        }catch(Throwable th) {
            th.printStackTrace();
        }
    }
   
    private T []data = null;
    private int size = 0;
    
    public MinHeap_using_Array(int initialCapacity) {
        data =(T[])new Object[initialCapacity];

    }
    
    public void print() {
        System.out.print("[");
        for(int i=0; i < size; i++) {
            if(i > 0)
                System.out.print(", ");
            System.out.print(data[i]);
        }
        System.out.print("]");
        System.out.println();
    }
    
    final int compare(Object k1, Object k2) {
        return  ((Comparable<? super T>)k1).compareTo((T)k2);
    }
    
    public void push(T val) throws Exception{
        if(isFull())
            throw new Exception("Heap is full!");
        data[size] = val;
        size ++;
        heapifyUp(size - 1);
    }
    
    private boolean isFull() {
        return size == data.length;
    }
    
    private boolean isEmpty() {
        return size == 0;
    }
    
    public T getMin() {
        if(isEmpty())
            return null;
        return data[0];
    }
    
    public T extractMin() {
        T min = getMin();
        if(min != null) {
            size --;
            if(size > 0) {
//                Copy last element to top
                data[0] = data[size];
                data[size] = null;
                heapifyDown(0);
            }
        }
        return min;
    }
    
    private void heapifyUp(int index) {
        if(index == 0)
            return;
        int parent = (index - 1) / 2;
        T parentVal = data[parent];
        T currVal = data[index];
        if(compare(parentVal,currVal) > 0) {
//            If parent value is greater
//            Then swap them
            data[index] = parentVal;
            data[parent] = currVal;
//            Now bubbleUp the parent
            heapifyUp(parent);
        }
//        else nothig to do
    }
    
    private void heapifyDown(int index) {
        int leftChild = index * 2 + 1;
        int rightChild = leftChild + 1;
        int minValIndex = size;
        
       if( leftChild >= size && rightChild >= size)
           return;
        
        T minVal = null;
        if(leftChild < size && rightChild < size) {
            T leftVal = data[leftChild];
            T rightVal = data[rightChild];
            minValIndex = leftChild;
            minVal = leftVal;
            if(compare(rightVal,leftVal) < 0) {
                minValIndex = rightChild;
                minVal = rightVal;
            }
        }else if(leftChild < size) {
            minValIndex = leftChild;
            minVal = data[leftChild];
        }else {
            minValIndex = rightChild;
            minVal = data[rightChild];
        }
        if(minVal != null && compare(minVal,data[index]) < 0) {
            data[minValIndex] = data[index];
            data[index] = minVal;
            heapifyDown(minValIndex);
        }
    }
}
