package Baekjoon;

import java.io.*;
import java.util.*;

//백준 1012번 유기농 배추

public class Baekjoon_1012 {
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int m;
    static int n;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            arr = new int[m][n];
            visit = new boolean[m][n];

            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = 1;
            }

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (arr[r][c] == 1 && !visit[r][c]) {
                        dfs(r, c);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=m || ny>=n){
                continue;
            }
            if(arr[nx][ny] == 1 && !visit[nx][ny]){
                dfs(nx,ny);
            }
        }
    }
}

