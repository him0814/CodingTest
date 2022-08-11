package baekjoon;
//덩치 백준 7568

//(x, y), (p, q)라고 할 때 x > p 그리고 y > q 덩치  "더 크다"
//둘 중 한가지가 더 클때 덩치 더 크다고 못함.
//덩치 등수는 덩치가 더 클 때만 적용.
//n명 집단에서 덩치 등수 출력.

import java.io.*;
import java.util.*;

public class Bulk {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<n; j++) {
			int cnt = 1;
			for(int k=0; k<n; k++) {
				if(j == k)
					continue;
				if(arr[j][0] < arr[k][0] && arr[j][1] < arr[k][1]) {
					cnt++;
				}
			}
			sb.append(cnt + " ");
		}
		System.out.println(sb);
	}
}
