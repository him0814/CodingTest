package BaekJoon;
// 첫째 줄 테스트 케이스 1 <= T <= 20
// 각 테스트 케이스 첫째 줄 지원자 1 <= N <= 100,000
// 서류심사 성적 면접 성적 순위 1위부터 N위까지 동석차 없이 결정
// 둘 다 석차가 높은 사람이 있다면 탈락

import java.io.*;
import java.util.*;

public class New_Recruits {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] score = new int[N + 1];
			
			for(int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				score[n] = m;
			}
			int count = 1;
			int tmp = score[1];
			for(int x = 2; x < N + 1; x++) {
				if(tmp > score[x]) {
					tmp = score[x];
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}
}
