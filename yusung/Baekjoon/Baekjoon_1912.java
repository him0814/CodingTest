package Baekjoon;

import java.io.*;
import java.util.*;

//백준 1912번 연속합

public class Baekjoon_1912 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum += num;
			max = Math.max(max, sum);
			
			if(sum<0) {
				sum=0;
			}
		}
		System.out.println(max);
	}
}
