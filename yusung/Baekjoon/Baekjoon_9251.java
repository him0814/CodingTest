package Baekjoon;

import java.io.*;
import java.util.*;

// 백준 9251번 LCS
// 문자열 알파벳 대문자/최대 1000글자
// 최장공통부분수열의 길이 출력하기
// 반례
// abcbd
// acbd

public class Baekjoon_9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int[][] dp = new int[a.length()+1][b.length()+1];
		
		for(int i=1; i<=a.length(); i++) {
			char ch = a.charAt(i-1);
			for(int j=1; j<=b.length(); j++) {
				if(ch == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		System.out.println(dp[a.length()][b.length()]);
		
//		String tmp1 ="";
//		if(b.length() > a.length()){
//			tmp1 = a;
//			a = b;
//			b = tmp1;
//		}
//		char[] astr = a.toCharArray();
//		char[] bstr = b.toCharArray();
//		List<Character> al = new ArrayList<>();
//
//		int na = 0;
//		int nb = 0;
//
//		while (true) {
//			if (na > astr.length - 1 || nb > bstr.length-1) {
//				break;
//			}
//
//			char tmp = ' ';
//			tmp = astr[na];
//
//			if (tmp == bstr[nb]) {
//				if (nb == bstr.length - 1) {
//					nb = bstr.length - 1;
//					na++;
//				}
//				al.add(tmp);
//				na++;
//				nb++;
//
//			} else {
//				if (nb == bstr.length - 1) {
//					nb = bstr.length - 1;
//					na++;
//				} else {
//					nb++;
//				}
//			}

//		}
//		System.out.println(al.size());
	}
}
