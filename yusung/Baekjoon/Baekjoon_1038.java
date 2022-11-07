package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 1038번 감소하는 수

public class Baekjoon_1038 {
	static List<Long> al;
	public static void main (String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		al = new ArrayList<>();
		// 1023개이지만 리스트의 인덱스는 0번부터 시작하므로 1022보다 커야됨
		if(N > 1022) {
			System.out.println(-1);
			return;
		}
		else {
			for(long i=0; i<10; i++) {
				dfs(i, 1);
			}			
		}		
		Collections.sort(al);
		System.out.println(al.get(N));
	}

	private static void dfs(long num, int depth) {		
		if(depth > 10) {
			return;
		}		
		
		//자리수를 10으로 나눈 나머지를 누적해서 더함
		//1 10
		//2 20 21
		//3 30 301 31 310 32 320 321
		al.add(num);
		for(int i=0; i<10; i++) {
			if(num%10 > i) {
				dfs((num*10) + i, depth+1);
			}
		}
	}
}
