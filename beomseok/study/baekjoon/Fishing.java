package baekjoon;
//백준 7573 고기잡이

import java.io.*;
import java.util.*;

public class Fishing {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int I = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<int[]> al = new ArrayList<>();
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			al.add(new int[] {x,y});
		}
		
		int res = 0;
		for (int i=0; i<M; i++) {
			for (int j=0; j<M; j++) {
				for (int k=1; k<I/2; k++) {
					int[] a = al.get(i);
					int[] b = al.get(j);
					
					int nx = Math.max(a[0], b[0]);
					int ny = Math.max(a[1], b[1]);
					
					int cnt = 0;
					for (int l=0; l<M; l++) {
						int[] now = al.get(l);
						if (now[0] <= nx && now[0]+k >= nx && now[1] <= ny && now[1]+(I/2-k) >= ny) {
							cnt++;
						}
					}
					res = Math.max(res, cnt);
				}
			}
		}
		System.out.println(res);
	}
}
