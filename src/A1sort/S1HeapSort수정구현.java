package A1sort;

import java.util.Arrays;

public class S1HeapSort수정구현 {

    public static void main(String[] args) {
        int[] intArr = {7, 6, 5, 8, 3, 5, 9, 1, 6};
        heapSort(intArr);
        System.out.println(Arrays.toString(intArr));
    }
    public static void heapSort(int[] intArr){
        int n = intArr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(intArr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = intArr[0];
            intArr[0] = intArr[i];
            intArr[i] = temp;
            heapify(intArr, i, 0);
        }
    }

    public static void heapify(int[] intArr, int n, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && intArr[left] > intArr[largest]) {
            largest = left;
        }
        if (right < n && intArr[right] > intArr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = intArr[i];
            intArr[i] = intArr[largest];
            intArr[largest] = swap;
            heapify(intArr, n, largest);
        }
    }
}
