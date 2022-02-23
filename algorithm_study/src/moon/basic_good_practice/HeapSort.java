package moon.basic_good_practice;

import java.util.Arrays;

// min heap
class heap_sort {
    int leftIdx;
    int rightIdx;
    int smallestIdx;
    static int tmp;

    // 힙구조 생성 (정렬))
    public void buildHeap(int[] arr, int size) {
        // 절반만 수행
        for (int i= (size/2)-1; i>=0; i-- ){
            heapify(arr, size, i);
        }
    }
    // 힙성질을 유지하기 위한 메서드
    public void heapify(int[] arr, int size, int rootIdx) {
        // root 공략
        leftIdx = 2*rootIdx + 1;
        rightIdx = leftIdx + 1;
        if (arr[rightIdx] > arr[leftIdx])
            smallestIdx = leftIdx;
        if (arr[rightIdx] > arr[rightIdx])
            smallestIdx = rightIdx;
        if (arr[rootIdx] != arr[smallestIdx])
            tmp = smallestIdx;
        arr[smallestIdx] = arr[rootIdx];
        arr[rootIdx] = arr[tmp];
        heapify(arr, size, smallestIdx);
    }

    // 힙정렬
    public int[] heapSort(int[] arr, int size){
        // 힙 구조로 정렬
        buildHeap(arr, size);

        // 힙 구조에서 노드 하나씩 접근 : 말단부터, 루트idx+1까지??
        for (int i= size-1; i>0; i-- ) {
            tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapify(arr, i, 0);  // 루트부터 힙정렬 시작
        }
        return arr;
    }

    // main code
    public static void main(String[] args) {
        heap_sort k = new heap_sort();
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        int[] sortedHeap = k.heapSort(arr, arr.length);
        Arrays.toString(sortedHeap);
    }
}
