package baekjoon;

//통나무 건너뛰기 백준 11497

//N개의 통나무

import java.io.*;
import java.util.*;

public class LogJumping {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			List<Integer> al = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				al.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(al);
			if (n % 2 == 0) {
				for(int k=n-1; k>0; k-=2) {
					al.add(al.get(k));
				}
				for(int l=n-1; l>=0; l-=2) {
					al.remove(l);
				}
			} else {
				for(int k=n-2; k>0; k-=2) {
					al.add(al.get(k));
				}
				for(int l=n-2; l>=0; l-=2) {
					al.remove(l);
				}
			}

			int tmp = Math.abs(al.get(0) - al.get(n - 1));
			for (int l = 1; l < al.size(); l++) {
				tmp = Math.max(tmp, Math.abs(al.get(l) - al.get(l - 1)));
			}
			sb.append(tmp + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
