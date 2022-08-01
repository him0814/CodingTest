package Baekjoon;

import java.io.*;
import java.util.*;

//백준 2675번 문자열 반복

public class Baekjoon_2675 {

	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//t 첫째줄 테스트케이스 개수
		int t = Integer.parseInt(br.readLine());		
		
		//r 반복할 횟수, s반복할 문자
		for(int i=0; i<t; i++) {
			//스트링 빌더 사용
			//StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			char[] s = st.nextToken().toCharArray();		
			
			for(int j=0; j<s.length; j++) {
				for(int k =0; k<r; k++) {
					System.out.print(s[j]);
					//sb.append(s[j]);
				}
			}
			//System.out.println(sb.toString());
			System.out.println();
		}		
	}
}

