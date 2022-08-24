package BaekJoon;
import java.io.*;
import java.util.*;
public class Padovan_Sequence {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			long[] arr = new long[101];
			arr[1] = 1;
			arr[2] = 1;
			arr[3] = 1;
			arr[4] = 2;
			arr[5] = 2;
			
			for(int j = 6; j <= N; j++) {
				arr[j] = arr[j - 1] + arr[j - 5];
			}
			sb.append(arr[N]).append("\n");
		}
		System.out.print(sb);
	}
}
