package Baekjoon;

import java.io.*;
import java.util.Arrays;

//백준 1339번 단어 수학
//알파벳 26개

public class Baekjoon_1339 {
	public static void main (String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] alphabet = new int[26];	
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				alphabet[str.charAt(j) - 'A'] += Math.pow(10, str.length()-j-1);
			}
		}
		Arrays.sort(alphabet);
		
		int k = 9;
		int sum = 0;
		for(int i = 25; i>=0; i--) {
			sum += alphabet[i] * k;
			k--;
		}
		System.out.println(sum);
	}

}
