package baekjoon;
//바이러스 백준 2606

import java.io.*;
import java.util.*;

public class Virus {
	static int n;
	static int m;
	static int com1;
	static int com2;
	static int cnt;
	static int arr[][];
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		arr = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			com1 = Integer.parseInt(st.nextToken());
			com2 = Integer.parseInt(st.nextToken());
			arr[com1][com2] = arr[com2][com1] = 1;
		}
		
		dfs(1);
		System.out.println(cnt);
	}
	public static void dfs(int x) {
		visit[x] = true;
		for(int i=1; i<=n; i++) {
			if(arr[x][i] == 1 && !visit[i]) {
				cnt++;
				dfs(i);
			}
		}
	}
}