package Baekjoon;

import java.io.*;
import java.util.*;

//백준 1149 RGB거리
//빨,초,파를 이웃과 겹치지 않게 칠하는데 드는 최소가격을 구하면됨

public class Baekjoon_1149 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            //첫번쨰를 빨강,초록,파랑으로 골랐을때를 모두 구한후 최소값을 출력함
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + red;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + green;
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + blue;
        }
        System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));

    }
}
