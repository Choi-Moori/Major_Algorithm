package A2dfs;

public class D4피로도 {
    public static int ans = 0;
    public static boolean[] visit;
    public static int[][] arr;

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons  = {{80,20}, {50,40}, {30,10}};
        visit = new boolean[dungeons.length];
        arr=dungeons;
        dfs(k, 0, arr.length);
        System.out.println(ans);
    }

    private static void dfs(int hp, int cnt, int leng) {
        ans = Math.max(cnt, ans);
        for(int i = 0 ; i < leng ; i++){
            if(visit[i]) continue;
            if(hp < arr[i][0]) continue;
            if(hp < arr[i][1]) continue;

            visit[i] = true;
            dfs(hp-arr[i][1] , cnt+1 , leng);
            visit[i] = false;
        }
    }
}
