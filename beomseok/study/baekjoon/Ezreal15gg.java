package baekjoon;
//백준 20500 Ezreal 여눈부터 가네 ㅈㅈ

import java.io.*;

public class Ezreal15gg {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long div = 1000000007;
		int N = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			System.out.print(0);
			return;
		} 
		
		long[][] arr = new long[1516][3];
		arr[2][0] = 1;
		arr[2][1] = 1;
		
		for(int i=3; i<=N; i++) {
			arr[i][0] = (arr[i-1][1] + arr[i-1][2]) % div;
			arr[i][1] = (arr[i-1][0] + arr[i-1][2]) % div;
			arr[i][2] = (arr[i-1][0] + arr[i-1][1]) % div;
		}
		System.out.print(arr[N][0]);
	}
}
