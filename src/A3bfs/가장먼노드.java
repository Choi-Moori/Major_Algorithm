package A3bfs;

import java.util.*;

public class 가장먼노드 {
    static boolean[] visit;
    static List<List<Integer>> adjList;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] dp;

    public static void main(String[] args) {
        int[][] edge = {{3, 6}, {4, 3},{3, 2},{1, 3}, {1, 2},{2, 4}, {5, 2}};
        int n = 6;
        int answer = 0;
        visit = new boolean[n+1];
        Arrays.fill(visit, true);
        adjList = new ArrayList<>();
        dp = new int[n+1];

        for (int i = 0; i < n+1; i++)
            adjList.add(new ArrayList<>());
        for (int[] e : edge) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        bfs(1);
        Arrays.sort(dp);
        int count = 1;
        for(int i = n-1 ; i > 0 ; i--){
            if(dp[i] != dp[n])
                break;
            count++;
        }
        System.out.println(count);
    }

    static public void bfs(int start){
        queue.add(start);
        visit[start] = false;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int target : adjList.get(temp)){
                if(visit[target]){
                    dp[target] = dp[temp] + 1;
                    queue.add(target);
                    visit[target] = false;
                }
            }
        }
    }
}
