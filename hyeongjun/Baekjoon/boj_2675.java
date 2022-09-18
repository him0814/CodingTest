package study1;

// 백준 #2675
// 문자열 S를 받은 후 각 문자를 R번 반복해 새로운 문자열 P를 만들어 출력
// S에는 QR Code "alphanumeric"   / QR Code "alphanumeric" answksms 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./:
// 첫째줄에는 테스트 케이스 개수 T(1<=T<=1000)
// 테스트케이스 반복 횟수 R(1<=R<=8)
// 문자열 S가 공백으로 구분, S의 길이는 적어도 1, 20글자 넘지않음

import java.io.*;
import java.util.*;

public class boj_2675 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 갯수 입력
		int testcnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < testcnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 문자가 반볼될 수
			int cnt = Integer.parseInt(st.nextToken());
			// 반복될 문자를 저장할 String 배열
			String word = st.nextToken();

			for (int j = 0; j < word.length(); j++) {
				for (int k = 0; k < cnt; k++) {
					// System.out.print -> 이어서 출력
					// System.out.println -> 출력하고 \n 후 출력
					// @@@@str.charAt(i) -> str 문자열의 i+1번째 문자, 죽 str을 char타입으로 변환하는 과정@@@@
					// System.out.print(word.charAt(k));
					// toCharArray(); 찾아보기  
					// split(); 찾아보기
					// 기본형변수 ()안붙음 ex) String[] , 참조형변수 ()붙음 String 형에만 ()붙음
					sb.append(word.charAt(j));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}