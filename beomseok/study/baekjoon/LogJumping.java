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
		
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			List<Integer> al = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				al.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(al);
			int startIdx = al.get(1);
			al.add(n, startIdx);
			
			int size = al.size();
			int idx = 0;
			for(int j=1; j<n; j+=2) {
				idx = al.get(j+2);
				al.add(size-1, idx);
			}System.out.println(al);
			al.remove(1);
			for(int k=0; k<(n/2)-1; k++) {
				al.remove(k+2);
			}
			
			int tmp = Math.abs(al.get(0) - al.get(n-1));
//			if(n%2 == 0) {
//				tmp = al.get(n/2) - al.get(n/2+1);
//			} else if(n%2 == 1) {
//				tmp = al.get(n/2) - al.get(n/2-1);
//			}
			for(int l=1; l<al.size(); l++) {
				tmp = Math.max(tmp, Math.abs(al.get(l)-al.get(l-1)));
			}
			sb.append(tmp + "\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
