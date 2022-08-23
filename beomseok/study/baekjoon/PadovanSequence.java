package baekjoon;
//파도반 수열 백준 9461

import java.io.*;

public class PadovanSequence {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long[] arr = new long[101];

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[1] = 1;
			arr[2] = 1;
			arr[3] = 1;

			for (int j = 4; j < 101; j++) {
				arr[j] = arr[j - 3] + arr[j - 2];
			}
			sb.append(arr[n] + "\n");
		}
		System.out.println(sb);
	}
}
