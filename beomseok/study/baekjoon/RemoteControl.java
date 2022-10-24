package baekjoon;
//백준 1107 리모컨

import java.io.*;
import java.util.*;

public class RemoteControl {
	static int N;
	static int M;
	static boolean broken[];
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		broken = new boolean[10];
		
		if(M > 0) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int br_button = Integer.parseInt(st.nextToken());
			broken[br_button] = true;
			}
		}
		int min = Math.abs(N - 100);
		
		for(int i=0; i<1000000; i++) {
			cnt = press(i);
			if(cnt != 0) {
				int tmp = Math.abs(i - N);
				min = Math.min(min, tmp+cnt);
			}
		}
		System.out.println(min);
	}
	public static int press(int i) {
		if(i == 0) {
			if(broken[0]) {
				return 0;
			} else {
				return 1;
			}
		}
		cnt = 0;
		while(i > 0) {
			if(broken[i%10]) {
				return 0;
			}
			cnt++;
			i /= 10;
		}
		return cnt;
	}
}
