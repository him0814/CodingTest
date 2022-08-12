package BaekJoon;

// 첫째 줄 컴퓨터 수 N 100이하
// 둘째 줄 연결된 쌍의 수 M 각각 단방향임 = 양방향으로 변환
// 셋째 줄 연결 번호 쌍
// 1번부터 바이러스 시작

import java.util.*;
import java.io.*;
public class Virus {
	
	static int N;
	static int M;
	static boolean[][] connect;
	static boolean[] visit;
	static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		connect = new boolean[N + 1][N + 1];
		visit = new boolean[N + 1];
		count = 0;
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			connect[n][m] = true;
			connect[m][n] = true;
		}
		
		dfs(1);
		
		System.out.print(count);
				
	}
	
	static void dfs(int com) {
		visit[com] = true;
		
		for(int i = 1; i <= N; i++) {
			if(!visit[i] && connect[com][i]) {
				dfs(i);
				count++;
			}
		}
	}
}
