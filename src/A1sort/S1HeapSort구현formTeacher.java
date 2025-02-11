package A1sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class S1HeapSort구현formTeacher {
    public static void main(String[] args) {
//        int[] arr = {7,6,5,8,3,5,9,1,6};
//        // 최초 힙 구성
//        for(int i = arr.length/2 - 1; i >= 0; i--){
//            heapify(arr, arr.length - 1, i);
//        }
//        System.out.println(Arrays.toString(arr));
//
//        // 루트노드와 최하위노드를 change 하면서 heapify
//        for(int i = arr.length - 1; i >= 0; i--){ // 최상단의 노드와 최하단의 노드를 change 해줘야 함
//            int temp = arr[i];
//            arr[i] = arr[0];
//            arr[0] = temp;
//            heapify(arr,i-1,0);
//        }
//        System.out.println(Arrays.toString(arr));

//        와 우
//        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
//        int k = 4;
//
//        Queue<Integer> pq = new PriorityQueue<>();
//        int[] answer = new int[score.length];
//        for(int i = 0 ; i < score.length;i++){
//            pq.add(score[i]);
//            if(pq.size() > k)
//                pq.poll();
//            answer[i] = pq.peek();
//        }
//        System.out.println(Arrays.toString(answer));

//        return answer;
    }

    static void heapify(int[] arr, int arrLength, int node) {

        // 왼쪽노드 : node * 2 + 1
        // 오른쪽 노드 : node * 2 + 2
        // check1 : 왼쪽, 오른쪽 노드가 배열의 길이보다 짧아야 함
        // check2 : node를 제외한 left, right 중 세개 중 가장 작은 노드로 다시 heapify
        int left = node * 2 + 1;
        int right = node * 2 + 2;
        if(left > arrLength)return;
        if( right > arrLength ){
            // node랑 left만 비교
            if(arr[node] > arr[left]){
                int temp = arr[node];
                arr[node] = arr[left];
                arr[left] = temp;
                heapify(arr, arrLength, node);
            }

        }else {
            // node, left, right 모두 비교
            int index = 0;
            if(arr[node] > arr[left] || arr[node] > arr[right]){
                if(arr[left] > arr[right]){
                    index = right;
                }else {
                    index = left;
                }
                int temp = arr[node];
                arr[node] = arr[index];
                arr[index] = temp;
                heapify(arr, arrLength, index);
            }

        }

    }
}
