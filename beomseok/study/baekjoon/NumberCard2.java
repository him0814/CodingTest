package baekjoon;
//숫자카드 백준 10816

//숫자 카드 N개, 정수 M개
//각각 수가 적힌 카드가 몇개 있는지 출력

import java.util.*;
import java.io.*;

public class NumberCard2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> hm = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			int numN = Integer.parseInt(st.nextToken());
			hm.put(numN, hm.getOrDefault(numN,0) +1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int j=0; j<M; j++) {
			int numM = Integer.parseInt(st.nextToken());
			if(hm.containsKey(numM)) {
				sb.append(hm.get(numM) + " ");
			} else {
				sb.append(0 + " ");
			}
		}
		//sb.setLength(0); 스트링 빌더 초기화 
		sb.setLength(sb.length() - 1); //출력 마지막 공백 제거
		System.out.println(sb);
	}
}
