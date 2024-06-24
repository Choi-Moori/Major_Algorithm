package A3bfs;

import java.util.*;

public class B1Basic3 {
    static int[][] arr;
    static boolean[] visit;
    static List<List<Integer>> adjList;
    static Queue<Integer> queue;
    static int[] dp;

    public static void main(String[] args) {
        arr = new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
        visit = new boolean[arr.length];
        Arrays.fill(visit, true);
        adjList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) adjList.add(new ArrayList<>());

        for (int i = 0; i < arr.length; i++) {
            for (int[] j : arr)
                if (j[0] == i) adjList.get(i).add(j[1]);
        }
        dp = new int[5];
        queue = new LinkedList<>();
        int start = 0;
        int end = 3;
        System.out.println(bfs(start,end));
    }
    static public int bfs(int start, int end){
        queue.add(start);
        visit[start]=false;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int target : adjList.get(temp)) {
                if (visit[target]) {
                    dp[target] = dp[temp] + 1;
                    queue.add(target);
                    visit[target] = false;
                }
                if(target == end){
                    return dp[target];
                }
            }
        }
        return -1;
    }
    static public int bfs(){

        return 1;
    }
}
