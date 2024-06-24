package A2dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D2Basic2 {
    static int[][] arr;
    static boolean[] visit;
    static List<List<Integer>> adjList;

    public static void main(String[] args) {
        arr = new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3,5} , {2, 4}};
        visit = new boolean[arr.length];
        Arrays.fill(visit,true);
        adjList = new ArrayList<>();

        for(int i = 0 ; i < arr.length; i++)
            adjList.add(new ArrayList<>());
        for(int i = 0 ; i < arr.length; i++){
            for(int[] j : arr) {
                if (j[0] == i) {
                    adjList.get(i).add(j[1]);
                    adjList.get(j[1]).add(i);
                }
            }
        }
        dfs(0);
    }
    static public void dfs(int start){
        System.out.println(start);
        visit[start] = false;
        for(int i : adjList.get(start)){
            if(visit[i])
                dfs(i);
        }
    }
}
