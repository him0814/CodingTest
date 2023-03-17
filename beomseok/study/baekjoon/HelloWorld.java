package baekjoon;
//น้มุ 13140 Hello World!

import java.io.*;

public class HelloWorld {
	static int N;
	static int[] num1 = { 2, 1, 3, 3, 4 };
	static int[] num2 = { 6, 4, 5, 3, 0 };
	static int[] arr;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[7];
		visit = new boolean[10];

		dfs(0);
		System.out.print("No Answer\n");

	}

	public static void check() {
		System.out.print("  ");
		for (int i = 0; i < 5; i++) {
			System.out.print(arr[num1[i]]);
		}

		System.out.print("\n+ ");
		for (int i = 0; i < 5; i++) {
			System.out.print(arr[num2[i]]);
		}

		System.out.println("\n-------");
		System.out.print(N > 100000 ? " " : "  ");
		System.out.print(N);
	}

	public static void dfs(int depth) {
		if (depth == 7) {
			if (arr[2] == 0 || arr[6] == 0)
				return;

			int sum = 0;
			for (int i = 0; i < 5; i++) {
				sum += arr[num1[i]] * Math.pow(10, 4 - i);
			}
			for (int i = 0; i < 5; i++) {
				sum += arr[num2[i]] * Math.pow(10, 4 - i);
			}

			if (sum == N) {
				check();
				System.exit(0);
			}
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i;
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}
}
