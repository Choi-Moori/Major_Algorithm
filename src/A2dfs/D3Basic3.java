package A2dfs;

import java.util.ArrayList;
import java.util.List;

public class D3Basic3 {
    static int[][] arr;
    static List<List<Integer>> adjList;
    static List<List<Integer>> visitList = new ArrayList<>();

    public static void main(String[] args) {
        arr = new int[][]{{1,2}, {1,3}, {2,4},{2,5},{3,6},{3,7}, {4,8}, {4,9}, {5,10}};
        adjList = new ArrayList<>();

        for(int i = 0 ; i < arr.length+2; i++){
            adjList.add(new ArrayList<>());
            for(int[] j : arr) {
                if (j[0] == i) {
                    adjList.get(i).add(j[1]);
                }
            }
        }
        dfs(1, new ArrayList<>());
        System.out.println(adjList);
        System.out.println(visitList);
    }

    public static void dfs(int start, List<Integer> arr){
        arr.add(start);
        if(adjList.get(start).isEmpty()){
            visitList.add(new ArrayList<>(arr));
            return;
        }
        for(int i : adjList.get(start)){
            dfs(i, arr);
            arr.remove(arr.size()-1);
        }
    }
}
