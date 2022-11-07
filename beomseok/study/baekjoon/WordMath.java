package baekjoon;
//백준 1339 단어수학

import java.io.*;
import java.util.*;

public class WordMath {
	static int N;
	static List<Character> al;
	static int[] arr;
	static String[] str;
	static int max = Integer.MIN_VALUE;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		al = new ArrayList<>();
		str = new String[N];
		
		for(int i=0; i<N; i++) {
			str[i] = br.readLine();
			for(int j=0; j<str[i].length(); j++) {
				if(!al.contains(str[i].charAt(j))) {
					al.add(str[i].charAt(j));
				}
			}
		}
		
		arr = new int[al.size()];
		visit = new boolean[10];
		
		dfs(0);
		System.out.println(max);
	}
	public static void dfs(int depth) {
		if(depth == al.size()) {
			int sum = 0;
			for(int i=0; i<N; i++){
				int tmp = 0;
				for(int j=0; j<str[i].length(); j++) {
					tmp *= 10;
					tmp += arr[al.indexOf(str[i].charAt(j))];
				}
				sum += tmp;
			}
			max = Math.max(sum, max);
			return;
		}
		
		for(int i=0; i<10; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i;
				dfs(depth + 1);
				arr[depth] = 0;
				visit[i] = false;
			}
		}
	}
}
