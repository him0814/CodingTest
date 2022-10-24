package BOJ;

import java.io.*;

public class boj_9461 {
	public static void main(String[] arg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test_cnt = Integer.parseInt(br.readLine());
		
		long[] arr = new long[100];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
 		
		for(int i = 0; i < test_cnt; i++) {
			int N = Integer.parseInt(br.readLine());
			for(int j = 3; j < N; j++) {
				arr[j] = arr[j-2] + arr[j-3];
			}
			sb.append(arr[N-1] + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
