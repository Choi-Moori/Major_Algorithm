package A2dfs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D1Basic {
    static int[][] arr;
    static boolean[] visit;
    static List<List<Integer>> adjList;
//    static int[][] arr2 = {{1,1,1,0,0}, {0,1,0,1,0}, {}};
    public static void main(String[] args) {
//        boolean[] visit = new boolean[arr.length];
//        Arrays.fill(visit, true);
//        방문할 수 있는 정점이 여러개인 경우 정점번호가 작은것을 먼저 방문하는
//        dfs알고리즘 형식의 방문순서를 출력하라.
        arr = new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
        visit = new boolean[arr.length];
        Arrays.fill(visit,true);
        adjList = new ArrayList<>();

        for(int i = 0 ; i < arr.length; i++){
            adjList.add(new ArrayList<>());
            for(int[] j : arr) {
                if (j[0] == i) {
                    adjList.get(i).add(j[1]);
                }
            }
        }
        dfs(0);

    }
    public static void dfs(int start){
        System.out.println(start);
        visit[start]=false;
        for(int i : adjList.get(start)){
            if(visit[i])
                dfs(i);
        }
    }
}
