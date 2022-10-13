package BOJ;

/*
백준 #1946 신입 사원
시간제한: 2초 -> 20억
N <= 100,000

1. (key-> 서류순위, value -> 면접 순위)  트리맵에 넣음
	
	k v
	---
	1 4  -> 서류순위가 1순위 이므로 무조건 선발
	2 5 
	3 6 
	4 2
	5 7 
	6 1
	7 3
	
2. 서류 순위 2등인 사람의 면접 점수는 5등인데 전 인덱스 면접 순위보다 안 좋음
3. 서류 순위 정렬이므로 서류 순위는 뒤쳐지므로 전 인덱스의 면접 순위보다 좋아야 선발됨
   -> value값만 전 인덱스 value값과 비교해서 작으면 선발 
 */

import java.io.*;
import java.util.*;

public class boj_1946 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			Map<Integer, Integer> tm = new TreeMap<>();
			
			// 1. (key-> 서류순위, value -> 면접 순위)  트리맵에 넣음
			for(int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				tm.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			int min = tm.get(1);
			int count = 1;
			
			// 3. 서류 순위 정렬이므로 서류 순위는 뒤쳐지므로 전 인덱스의 면접 순위보다 좋아야 선발됨
			for(int j: tm.keySet()) {
				if(tm.get(j) < min) {
					min = tm.get(j);
					count++;
				}
			}
			sb.append(count+"\n");
		}
		System.out.println(sb.toString());
	}
}
