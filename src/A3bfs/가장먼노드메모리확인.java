package A3bfs;

import java.util.*;

public class 가장먼노드메모리확인 {
    static List<List<Integer>> adjList;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] dp;

    public static void main(String[] args) {
        int[][] edge = {{3, 6}, {4, 3},{3, 2},{1, 3}, {1, 2},{2, 4}, {5, 2}};
        int n = 6;
        int answer = 0;

        adjList = new ArrayList<>();
        dp = new int[n+1];
        Arrays.fill(dp, -1);

        for (int i = 0; i < n+1; i++)
            adjList.add(new ArrayList<>());
        for (int[] e : edge) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        bfs(1);
        Arrays.sort(dp);
        int count = 1;
        int maxdis = 0;
        for(int i : dp){
            if(i > maxdis){
                maxdis =i;
                count = 1;
            }
            else if(maxdis == i)
                count++;
        }
        System.out.println(count);
    }

    static public void bfs(int start){
        queue.add(start);
        dp[start]= 0;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int target : adjList.get(temp)){
                if(dp[target] == -1){
                    dp[target] = dp[temp] + 1;
                    queue.add(target);
                }
            }
        }
    }
}
