package BaekJoon;
// 첫째 줄 테스트케이스 T
// 각 첫째 줄 통나무 개수 5 <= N <=10,000
// 각 둘째 줄 통나무 높이 1 <= L <= 100,000

import java.util.*;
import java.io.*;
public class Log_Jumping {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int odd = arr[1] - arr[0];
			int even = arr[2] - arr[0];
			int last = arr[N-1] - arr[N-2];
			
			for(int k = 3; k < N; k++) {
				if(k%2==1) {
					odd = Math.max(odd, arr[k] - arr[k-2]);
				}
				else {
					even = Math.max(even, arr[k] - arr[k-2]);
				}
			}
			last = Math.max(Math.max(even, odd), last);
			sb.append(last).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
