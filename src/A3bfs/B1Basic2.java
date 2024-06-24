package A3bfs;

import java.util.*;

public class B1Basic2 {
    static int[][] arr;
    static boolean[] visit;
    static List<List<Integer>> adjList;
    static Queue<Integer> queue;

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

        int[] dp = new int[6];

        queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.println(temp);
            for (int target : adjList.get(temp)) {
                if(visit[target]) {
                    dp[target] = dp[temp] + 1;
                    queue.add(target);
                    visit[target] = false;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
