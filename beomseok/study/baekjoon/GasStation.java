package baekjoon;
//주유소 백준 13305

//첫 번째 줄에는 도시의 개수를 나타내는 정수 N(2 ≤ N ≤ 100,000)
//다음 줄에는 인접한 두 도시를 연결하는 도로의 길이가 제일 왼쪽 도로부터 N-1개의 자연수
//다음 줄에는 주유소의 리터당 가격이 제일 왼쪽 도시부터 순서대로 N개의 자연수
//제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수


import java.io.*;
import java.util.*;

public class GasStation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] len = new long[n-1];
		long[] price = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n-1; i++) {
			len[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int j=0; j<n; j++) {
			price[j] = Integer.parseInt(st.nextToken());
		}
		
		long costSum = 0;
		long cheapPrice = price[0];
		
		for(int k=0; k<n-1; k++) {
			if(price[k] < cheapPrice) {
				cheapPrice = price[k];
			}
			costSum += cheapPrice * len[k];
		}
		System.out.println(costSum);
	}
}
