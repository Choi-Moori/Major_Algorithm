package A1sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class S1HeapSort구현 {
//    static int[] intArr = {1,234,158,978,241,2568,1234357,56876,4865,54376807,32512,12342,12347655,457797,2546584};
    static int[] intArr = {7,6,5,8,3,5,9,1,6};
    static boolean[] visit = new boolean[intArr.length];

    public static void main(String[] args) {
        Arrays.fill(visit, true);
//        최초힙 구성
        firstheap(0, intArr.length);
        for(int i = 0 ; i < intArr.length ; i++){
            if(visit[visit.length-1-i]){
                int temp = intArr[0];
                intArr[0] = intArr[intArr.length-1-i];
                intArr[intArr.length-1-i] = temp;
                visit[intArr.length-1-i] = false;
                System.out.println(Arrays.toString(intArr));
            }
            firstheap(0, intArr.length-1-i);
        }

    }
    //    초기힙만들기
    static void firstheap(int start, int leng){
        int left = start * 2 + 1;
        int right = start * 2 + 2;
        if(left >= leng || right >= leng){
            return;
        }
        else {
            firstheap(left, leng);
            firstheap(right, leng);
            if(intArr[right] > intArr[left]) {
                if (intArr[right] > intArr[start] && visit[right]) {
                    int temp = intArr[right];
                    intArr[right] = intArr[start];
                    intArr[start] = temp;
                }
            }
            else {
                if (intArr[left] > intArr[start] && visit[left]) {
                    int temp = intArr[left];
                    intArr[left] = intArr[start];
                    intArr[start] = temp;
                }
            }
        }
    }
}
