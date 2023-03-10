package Baekjoon;

//백준 17281 야구공
import java.io.*;
import java.util.*;

public class Baekjoon_17281 {
	static boolean[] visit;
	static int[] player;
	static int N;
	static int[][] arr;
	static int max = Integer.MIN_VALUE;
	static int outcount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[9];
		player = new int[9];
		arr = new int[N][9];
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		player[3] = 0;
		visit[3] = true;
		dfs(1);
		System.out.println(max);

//		배열확인
//		for(int i=0; i<arr.length; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());{
//				for(int j=0; j<arr[i].length; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
//		}
	}

	private static void dfs(int depth) {
		if (depth == 9) {
			int max2 = check();
			max = Math.max(max, max2);
			return;
		}

//		if (depth == 4) {
//			dfs(depth + 1);
//			return;
//		}

		for (int i = 0; i < player.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				player[i] = depth;
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}

	private static int check() {
		int sum = 0;		
		int saveplayer = 0;

		for (int i = 0; i < N; i++) {
			outcount = 0;
			boolean[] base = new boolean[3];
			int score = 0;
			while (outcount < 3) {
				int M = arr[i][player[saveplayer]];

				if (M == 0) {
					outcount++;					
				}
				// 안타
				else if (M == 1) {
					if (base[2]) {
						score++;
						base[2] = false;
					}
					if (base[1]) {
						base[2] = true;
						base[1] = false;
					}
					if (base[0]) {
						base[1] = true;
					}
					base[0] = true;
					
				}

				// 2루타
				else if (M == 2) {
					if (base[2]) {
						score++;
						base[2] = false;
					}
					if (base[1]) {
						score++;
					}
					if (base[0]) {
						base[2] = true;
						base[0] = false;
					}
					base[1] = true;
					
				}

				// 3루타
				else if (M == 3) {
					if (base[2]) {
						score++;
					}
					if (base[1]) {
						score++;
						base[1] = false;
					}
					if (base[0]) {
						score++;
						base[0] = false;
					}
					base[2] = true;
					
				}

				// 홈런
				else if (M == 4) {
					if (base[2]) {
						score++;
						base[2] = false;
					}
					if (base[1]) {
						score++;
						base[1] = false;
					}
					if (base[0]) {
						score++;
						base[0] = false;
					}
					score++;
					
				}

				saveplayer++;
				if (saveplayer >= 9) {
					saveplayer = 0;
				}				
			}
			sum += score;
		}

		return sum;
	}
}
