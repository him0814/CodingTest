package BOJ;

import java.io.*;

public class BOJ_1003_fibonacci {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i = 2; i <= 40; i++){
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            sb.append(dp[num][0]).append(" ").append(dp[num][1]).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
