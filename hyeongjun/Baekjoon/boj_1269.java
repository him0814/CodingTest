package BOJ;

/*
백준 #1269 대칭차집합
집합 A, 집합 B의 서로간의 차집합의 원소의 갯수를 구하면됌
A-B 갯수 + B-A 갯수 
 */

import java.util.*;
import java.io.*;

public class boj_1269 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Set<Integer> a_hs = new HashSet<>();
		Set<Integer> b_hs = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// a_hs에 1,2,4 추가
		for(int i = 0; i < a; i++) {
			a_hs.add(Integer.parseInt(st.nextToken()));
		}
				
		st = new StringTokenizer(br.readLine(), " ");
		
		// b_hs에 2,3,4,5,6 추가
		for(int i = 0; i < b; i++) {
			b_hs.add(Integer.parseInt(st.nextToken()));
		}
		
		int count = 0;
		
		for(int now: a_hs) {
			// a_hs에 포함되지 않으면 count++
			if(!b_hs.contains(now)) {
				count++;
			}
		}
		
		for(int now: b_hs) {
			// bs_hs에 포함되지 않으면 count++
			if(!a_hs.contains(now)) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}
