package BaekJoon;

import java.io.*;
import java.util.*;

public class Cal_Date {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] esm = new int[3];
		for(int i = 0; i < 3; i++) {
			esm[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] compare = new int[3];
		
		Arrays.fill(compare, 1);
		int count = 1;
		while(esm[0] != compare[0] || esm[1] != compare[1] || esm[2] != compare[2]) {
			compare[0]++;
			compare[1]++;
			compare[2]++;
			
			if(compare[0] == 16) {
				compare[0] = 1;
			}
			if(compare[1] == 29) {
				compare[1] = 1;
			}
			if(compare[2] == 20) {
				compare[2] = 1;
			}
			
			count++;
		}
		System.out.print(count);
	}
}
