package baekjoon;
//ATM 백준 11399
//N: ATM앞에 서있는 사람들 수
//i: 1번부터 N번까지 번호
//Pi: i번 사람이 돈을 인출하는데 걸리는 시간
//각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값
//첫째 줄에 사람의 수 N(1 ≤ N ≤ 1,000)
//둘째 줄에는 각 사람이 돈을 인출하는데 걸리는 시간 Pi(1 ≤ Pi ≤ 1,000)

import java.io.*;
import java.util.*;

public class ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int front = 0; // 맨 앞 사람
		int sum = 0; // 최소 합
		
		for(int j=0; j<n; j++) {
			front += arr[j];
			sum += front;
		}
		System.out.println(sum);
	}

}
