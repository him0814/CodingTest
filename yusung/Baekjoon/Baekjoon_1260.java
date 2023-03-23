package Baekjoon;

import java.io.*;
import java.util.*;

//백준 1260번 DFS와 BFS

public class Baekjoon_1260 {
    static boolean visit[];
    static int[][] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = 1;
            arr[end][start] = 1;
        }

        visit = new boolean[N+1];
        sb = new StringBuilder();
        dfs(V);
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());

        visit = new boolean[N+1];
        sb = new StringBuilder();
        sb = bfs(V);
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());

    }

    private static void dfs(int depth) {
        visit[depth] = true;
        sb.append(depth).append(" ");
        if(depth == arr.length){
            return;
        }

        for(int i=1; i<arr.length; i++){
            if(arr[depth][i] == 1 && !visit[i]){
                dfs(i);
            }
        }
    }

    private static StringBuilder bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;
        sb.append(start)
                .append(" ");

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=1; i<arr.length; i++){
                if(arr[now][i] == 1 && !visit[i]){
                    q.offer(i);
                    visit[i] = true;
                    sb.append(i)
                            .append(" ");
                }
            }
        }
        return sb;
    }
}
