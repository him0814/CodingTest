package baekjoon;
//신입사원 백준 1946

//다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 
//적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발

//첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 20)
//테스트 케이스의 첫째 줄에 지원자의 숫자 N(1 ≤ N ≤ 100,000)
//둘째 줄부터 N개 줄에는 각각의 지원자의 서류심사 성적, 면접 성적의 순위(사이에 공백)
//1위부터 N위까지 동석차 없음

import java.util.*;
import java.io.*;

public class Newcomer {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n+1];
			
			for(int j=0; j<n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int rank = Integer.parseInt(st.nextToken());
				arr[rank] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 1;
			int first = arr[1];
			for(int k=1; k<n; k++) {
				if(arr[k] < first) {
					cnt++;
					first = arr[k];				
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
}
