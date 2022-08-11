package Baekjoon;

import java.io.*;

//백준 1748번 수 이어쓰기1
//입력받은 N값을 1~N까지 쭉 나열했을떄 나오는 자릿수를 출력하면됨
//N은 1~1억까지
//시간제한 0.15초 ? for문 한번?
//1~9는 그대로
//10~99는 10을 곱하고
//99~999는 100을 곱함

public class Baekjoon_1748 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cipher = 0; //자릿수
		int cipher_plus = 1; //자릿수 올림 변수
		int mul = 10; // 10, 100, 1000곱할 변수
		
		for(int i=1; i<=N; i++) {
			if(i%mul == 0) {
				cipher_plus++;
				mul *= 10;
			}
			
			cipher +=cipher_plus;
		}
		System.out.println(cipher);
	}
}
