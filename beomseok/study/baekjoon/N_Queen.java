package baekjoon;
//น้มุ 9663 N-Queen

import java.io.*;

public class N_Queen {
	static int N;
	static int[] arr;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		cnt = 0;
		
		dfs(0);
		System.out.println(cnt);
	}
	public static void dfs(int depth) {
		if(depth == N) {
			cnt++;
			return;
		}
		for(int i=0; i<N; i++) {
			boolean flag = true;
			arr[depth] = i;
			for(int j=0; j<depth; j++) {
				if(arr[depth] == arr[j]) {
					flag = false;
					break;
				} else if(Math.abs(depth - j) == Math.abs(arr[depth] - arr[j])) {
					flag = false;
					break;
				}
			}
			if(flag) {
				dfs(depth + 1);
			}
		}
	}
}
