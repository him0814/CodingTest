package Baekjoon;

import java.io.*;

//백준 13140번 Hello World!
// 0~9 까지 서로다른 7개의 수를 뽑기

public class Baekjoon_13140 {

	static boolean[] visit = new boolean[10];
	static int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static int[] res = new int[7];// h e l o w r d
	static int depth = 0;		
	static int hello = 0;
	static int world = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean flag = dfs(arr, visit, depth, N);

		if (!flag) {
			System.out.println("No Answer");
		} 
		else {
			int tmp = hello + world;
			System.out.println("  " + res[0] + res[1] + res[2] + res[2] + res[3]);
			System.out.println("+ " + res[4] + res[3] + res[5] + res[2] + res[6]);
			System.out.println("-------");
			if (tmp < 100000) {
				System.out.println("  " + tmp);
			} else {
				System.out.println(" " + tmp);
			}
		}

	}

	private static boolean dfs(int[] arr, boolean[] visit, int depth, int N) {			
		if (depth == 7) {
			return true;
		}

		for (int i = 0; i < arr.length; i++) {
			if (visit[i] != true) {
				if (res[0] != 0 && res[4] != 0 && hello + world == N) {
					break;
				}
				visit[i] = true;
				res[depth] = arr[i];
				dfs(arr, visit, depth + 1, N);
				visit[i] = false;
				hello = 10000 * res[0] + 1000 * res[1] + 100 * res[2] + 10 * res[2] + res[3];
				world = 10000 * res[4] + 1000 * res[3] + 100 * res[5] + 10 * res[2] + res[6];
			}			
		}
		if (hello + world != N) {
			return false;
		}
		return true;
	}
}
