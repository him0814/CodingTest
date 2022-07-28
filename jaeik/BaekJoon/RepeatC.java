package BaekJoon;

// 문자열 반복
// 첫번쨰줄 테스트 케이스의 수
// 숫자 입력 = 반복의 수, 띄어쓰기로 구분후 단어들을 n번 반복해서 출력

import java.io.*;
import java.util.*;

public class RepeatC {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			String[] sarr = s.split("");
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < sarr.length; j++) {
				for(int x = 0; x < r; x++) {
					sb.append(sarr[j]);
				}
			}
			System.out.println(sb.toString());
		}
	}
}