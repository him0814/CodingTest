package baekjoon;

// 백준 문자열 반복 2675

// S : 입력받은 문자열
// R : 문자를 반복할 횟수
// P : 출력할 새로 만들어진 문자열
// ------입력------
// 첫째 줄: 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)
// 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분
// 1 <= S의 길이 <= 20 

import java.io.*;
import java.util.*;

public class RepeatingChar {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); //테스트케이스 입력
		for(int i=0; i<t; i++) { //테스트케이스 횟수
			StringTokenizer st = new StringTokenizer(br.readLine()," "); //공백 처리
			int r = Integer.parseInt(st.nextToken()); //문자 반복
			String s = st.nextToken(); //입력 문자열
			for(int j=0; j < s.length(); j++) { //s의 길이만큼 반복
				for(int k=0; k<r; k++) { // 문자열을 r만큼 반복  
					System.out.print(s.charAt(j)); // 반복된 문자열을 한글자씩만 때와서 출력
				}
			}
			System.out.println();
		}
	}

}
