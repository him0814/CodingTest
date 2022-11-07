package baekjoon;

import java.io.*;
import java.util.*;

public class DecreasingNumber {
	static int N;
	static List<Long> al;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		al = new ArrayList<>();
		
		if(N <= 10) {
			System.out.println(N);
		} else if(N > 1022) {
			System.out.println("-1");
		} else {
			for(int i=0; i<10; i++){
				dfs(i, 1);
			}
			Collections.sort(al);
			System.out.println(al.get(N));
		}
	}
	public static void dfs(long x, int depth) {
		if(depth > 10) {
			return;
		}
		al.add(x);
		for(int i=0; i<(x%10); i++) {
			dfs((x * 10) + i, depth + 1);
		}
	}
}
