package baekjoon;
//백준 15684 사다리 조작

import java.io.*;
import java.util.*;

public class LadderOperation {
	static int N, M, H;
	static int a, b;
	static int res;
	static int[][] arr;
	static boolean flag;
	public static void main(String srgs[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 
		H = Integer.parseInt(st.nextToken()); 
		arr = new int[H + 1][N + 1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1; //오른쪽
			arr[a][b + 1] = -1; //왼쪽
		}
		
		for(int i=0; i<=3; i++) {
			res = i;
			dfs(1, 0);
			if(flag) break;
		}
		if(flag) {
			System.out.print(res);
		} else {
			System.out.print(-1);
		}
	}
	public static void dfs(int at, int depth) {
		if(flag) {
			return;
		}
		
		if(depth == res) {
			if(check()) {
				flag = true;
			}
			return;
		}
		
		for(int i=at; i<=H; i++) {
			for(int j=1; j<N; j++) {
				if(arr[i][j] == 0 && arr[i][j+1] == 0) {
					arr[i][j] = 1;
					arr[i][j+1] = -1;
					dfs(i, depth+1);
					arr[i][j] = 0;
					arr[i][j+1] = 0;
				}
			}
		}
	}
	public static boolean check() {
		for(int i=1; i<=N; i++) {
			a = 1;
			b = i;
			for(int j=0; j<H; j++) {
				if(arr[a][b] == 1) {
					b++;
				} else if(arr[a][b] == -1) {
					b--;
				}
				a++;
			}
			if(b != i) {
				return false;
			}
		}
		return true;
	}
}
