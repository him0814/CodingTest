package baekjoon;
//수 이어쓰기 백준 1748

//1부터 N까지의 수를 이어서 씀
//만들어진 새로운 수는 몇 자리 수인지 출력

//첫째 줄에 N(1 ≤ N ≤ 100,000,000)

import java.io.*;

public class Broj {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int tmp = 10;
		int cnt = 1;
		int nOfd = 0; //자릿 수
		
		for(int i=1; i<=n; i++) {
			if(i == tmp) { //자릿 수 두자리 부터 늘려주기
				cnt++;
				tmp *= 10;
			}
			nOfd += cnt;
		}
		System.out.println(nOfd);
	}
}
