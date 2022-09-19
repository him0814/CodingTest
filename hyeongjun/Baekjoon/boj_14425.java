package BOJ;

/*
백준 #14425
입력 N개의 문자열 -> 집합 S에 포하되는 문자열
입력 M개의 문자열 -> 검사해야하는 문자열
hashmap 사용
 */

import java.io.*;
import java.util.*;

public class boj_14425 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, String> hm = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 1~5번째 문자열을 hm.put()
		for(int i = 0; i < N; i++) {
			hm.put(br.readLine(), "a");
		}

		// 몇 개가 포함 되어 있는지
		int count = 0;
		
		// 1~11번째 문자열이 hashmap에 포함되어있으면 count++
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			if(hm.containsKey(str)) {
				count++;
			}
		}
		System.out.println(count);
	}
}
