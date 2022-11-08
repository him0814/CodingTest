package baekjoon;
//백준 13164 행복 유치원

import java.io.*;
import java.util.*;

public class HappyKindergarden {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] m_arr = new int[N-1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N-1; i++) {
			m_arr[i] = arr[i+1] - arr[i];
		}
		
		Arrays.sort(m_arr);
		
		int ans = 0;
		for(int i=0; i<N-K; i++) {
			ans += m_arr[i];
		}
		System.out.println(ans);
	}
}
