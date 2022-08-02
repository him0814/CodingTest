package Baekjoon;

import java.util.*;
import java.io.*;
//백준 1302번 베스트셀러
//해쉬맵에 같은값이 들어오면 밸류값+1씩증가 시켜서 넣음
//밸류중에서 제일 큰값 찾아서 리턴

//스트링 사전순 비교
//str1.compareTo(str2) > 0 
//str2 가 사전 순 앞에있음
//
//str1.compareTo(str2) < 0
//str1이 사전 순 앞에 있음 
//
//str1.compareTo(str2) == 0
//str1과 str2가 사전 순으로 같음

public class Baekjoon_1302 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> hm = new HashMap<>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			hm.put(str, hm.getOrDefault(str, 0)+1);
		}
		
		int max = 0;
		String maxStr = "";
		for(String key : hm.keySet()) {
			if(hm.get(key) > max) {
				max = hm.get(key);
				maxStr = key;
			}
			else if(hm.get(key)==max){
				if(maxStr.compareTo(key)>0) {//입력된 스트링의 횟수가 같을때비교, key가 Str보다 사전순 앞에 있게 정렬 이때 key를 maxStr에 넣어서 출력
					maxStr = key;
				}
			}
		}
		System.out.println(maxStr);
	}
}
