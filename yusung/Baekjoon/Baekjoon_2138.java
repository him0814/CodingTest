package Baekjoon;

import java.io.*;
import java.util.*;

//백준 2138번 전구와 스위치

public class Baekjoon_2138 {
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str1 = br.readLine();		
		String str2 = br.readLine();
		boolean[] tmp1 = new boolean[N];//1번 스위치를 안킨거
		boolean[] tmp2 = new boolean[N];//1번 스위치를 킨거
		boolean[] goal = new boolean[N];
		
		for(int i = 0; i<N;i++) {
			if(str1.charAt(i) == '1') {
				tmp1[i] = true;
				tmp2[i] = true;
			}
			if(str2.charAt(i) == '1') {
				goal[i] = true;
			}
		}
		
		//1번 스위치 변경과정
		tmp2[0] = !tmp2[0];
		tmp2[1] = !tmp2[1];
		int tmp1_count = 0;
		int tmp2_count = 1;	
		
		for(int i=1; i<N-1; i++) {
			if(tmp1[i-1] != goal[i-1]) {
				tmp1 = change(tmp1, i);
				tmp1_count++;
			}
			if(tmp2[i-1] != goal[i-1]) {
				tmp2 = change(tmp2, i);
				tmp2_count++;
			}
			
		}
		
		if(tmp1[N-2] != goal[N-2]) {
			tmp1 = change2(tmp1, N);
			tmp1_count++;
		}
		if(tmp2[N-2] != goal[N-2]) {
			tmp2 = change2(tmp2, N);
			tmp2_count++;
		}
		
		if(tmp1[N-1] != goal[N-1] && tmp2[N-1] != goal[N-1]) {
			System.out.println(-1);
		}
		else if(tmp1[N-1] == goal[N-1] && tmp2[N-1] != goal[N-1]) {
			System.out.println(tmp1_count);
		}
		else if(tmp1[N-1] != goal[N-1] && tmp2[N-1] == goal[N-1]) {
			System.out.println(tmp2_count);
		}
		else if(tmp1[N-1] == goal[N-1] && tmp2[N-1] == goal[N-1]) {
			System.out.println(Math.min(tmp1_count, tmp2_count));
		}
		
	}

	private static boolean[] change2(boolean[] tmp, int N) {
		tmp[N-2] = !tmp[N-2];
		tmp[N-1] = !tmp[N-1];
		return tmp;
	}

	private static boolean[] change(boolean[] tmp, int i) {
		tmp[i-1] = !tmp[i-1];
		tmp[i] = !tmp[i];
		tmp[i+1] = !tmp[i+1];	
		return tmp;
	}

}
