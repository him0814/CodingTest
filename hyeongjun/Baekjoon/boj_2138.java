package BOJ;

/*
백준 #2138 전구와 스위치

i번째 전구 스위치 누르면 i-1, i , i+1 다 바뀜

전구 상태 바꾸는 방법..
-> start = start ^ 1;
 
0 ^ 0 = 0
0 ^ 1 = 1
1 ^ 0 = 1
1 ^ 1 = 0

첫번째 스위치 누르냐 마냐 -> 두번째 스위치 누르냐 마냐 -> 세번째 스위치 누르냐 마냐
처음 dfs 돌때 첫번째 스위치 누르냐 마냐
i) 첫번째 스위치 안 누른다
ii) 첫번째 스위치  누른다

 */

import java.io.*;

public class boj_2138 {
	
	static int n;
	static int[] start;
	static int[] target;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		start = new int[n];
		target = new int[n];
		
		for(int i = 0; i < 2; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				if(i == 0) {
					start[j] = str.charAt(j) - '0';
				} else {
					target[j] = str.charAt(j) - '0';
				}
			}
		}
		
		// 첫번째거를 안키고 보는거
		dfs(1,0);
		
		// 첫번째거를 키고 보는거
		start[0] = start[0] ^ 1;
		start[1] = start[1] ^ 1;
		dfs(1,1);
		
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	private static void dfs(int idx, int cnt) {
		if(idx == start.length - 1) {
			// n-1번째 스위치를 누르지 않아도 같은 경우
			if(start[idx] == target[idx] && start[idx - 1] == target[idx - 1]) {
				min = Math.min(min, cnt);
				return;
			}
			// n-1번째 스위치를 누르면 같아지는 경우
			if((start[idx]^1) == target[idx] && (start[idx - 1]^1) == target[idx - 1]) {
				min = Math.min(min, cnt+1);
				return;
			} else {
				return;
			}
		}
		
		if(start[idx - 1] == target[idx - 1]) { // idx-1번째 전구가 상태가 같으면 스위치 누를 필요 x
			dfs(idx+1, cnt);
		} else {
			// idx번째 스위치를 누른 경우
			start[idx] = start[idx] ^ 1;
			start[idx - 1] = start[idx - 1] ^ 1;
			start[idx + 1] = start[idx + 1] ^ 1;
			dfs(idx + 1, cnt + 1);
			start[idx] = start[idx] ^ 1;
			start[idx - 1] = start[idx - 1] ^ 1;
			start[idx + 1] = start[idx + 1] ^ 1;
		}
		return;
	}
	
	
}
