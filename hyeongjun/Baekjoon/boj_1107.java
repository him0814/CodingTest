package BOJ;


/*
백준 #1107 리모컨

n -> 타겟채널
m -> 고장난 버튼수

채널 최대 500,000
현재 채널 100


 */

import java.io.*;
import java.util.*;

public class boj_1107 {
	
	static boolean[] error;
	static int n, m;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		error = new boolean[10];
		min = Integer.MAX_VALUE;
		
		if(m > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 고장난 채널 -> true
			// 누를 수 있는 채널 -> false
			for(int i = 0; i < m; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				error[tmp] = true;
			}
		}
		
		// 타겟채널이 100이면 0 출력
		if(n == 100) {
			System.out.println(0);
			return;
		}
		
		// 채널 n까지 +.- 버튼으로만 이동했을 때
		int pmb = Math.abs(100-n);
		if(min > pmb) {
			min = pmb;
		}
		// Math.min(min, pmb);
		// min = min > pmb ? pmb : min;
		
		dfs(0, "");
		
		System.out.println(min);
	}
	private static void dfs(int idx, String button) {
		for(int i = 0; i < 10; i++) {
			if(!error[i]) {
				String str = button + Integer.toString(i);
				// 숫자 버튼 누른 횟수 + (+,- 버튼눌러서 이동한 횟수)
				int count = Math.abs(n - Integer.parseInt(str)) + str.length();
				if(min > count) {
					min = count;
				}
				
				// 채널은 최대 500,000 -> 여섯자릿수
				if(idx < 6) {
					dfs(idx+1, str);
				} 
			}
		}
	}
}
