package BaekJoon;

// 첫 줄에는 테스트케이스 수를 나타내는 자연수 T
// 각 테스트케이스 별로 첫 줄에는 날의 수를 나타내는 자연수 N(2 ≤ N ≤ 1,000,000)
// 둘째 줄에는 날 별 주가를 나타내는 N개의 자연수

import java.util.*;
import java.io.*;

public class Stock {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int max = 0;
			int[] stock = new int[N];
			int index = 0;
			
			for(int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				stock[j] = n;
				if(n > max) {
					max = n;
					index = j;
				}
			}
			long sum = 0;
			int k = 0;
			
			
			while(true) {
				
				for(int x = k; x <= index; x++) {
					sum += max - stock[x];
				}
				
				if(index == N - 1) {
					break;
				}
				
				k = index + 1;
				max = 0;
				for(int y = k; y < N; y++) {
					if(stock[y] > max) {
						max = stock[y];
						index = y;
					}
				}
				
			}
			sb.append(sum + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}
}
