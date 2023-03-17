package baekjoon;
//백준 17281 야구

import java.io.*;
import java.util.*;

public class Baseball {
	static int N;
	static boolean[] visit;
	static int[] player;
	static int[][] arr;
	static int res = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		player = new int[10];
		arr = new int[N+1][10];
		visit = new boolean[10];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		player[4] = 1;
		visit[4] = true;
		
		dfs(2);
		System.out.println(res);
	}
	public static void dfs(int depth) {
		if(depth == 10) {
			res = Math.max(res, score());
			return;
		}
		for(int i=1; i<=9; i++) {
			if(!visit[i]) {
				visit[i] = true;
				player[i] = depth;
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}
	public static int score() {
		int sum = 0;
		int first = 1;
		
		for(int i=1; i<=N; i++) {
			int[] num = new int[5];
			while(num[0] < 3) {
				int base = arr[i][player[first]];
				for(int j=0; j<base; j++) {
					num[4] += num[3];
					num[3] = num[2];
					num[2] = num[1];
					num[1] = 0;
				}
				num[base]++;
				
				if(first == 9) first = 1;
				else first++;
			}
			sum += num[4];
		}
		return sum;
	}
}
