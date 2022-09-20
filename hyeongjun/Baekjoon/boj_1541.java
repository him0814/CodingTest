package BOJ;

/*
백준 #1541 잃어버린 괄호
시간 제한: 2초 -> 20억

연산이 -으로만 또는 +으로만 있으면 그대로 연산
- 연산과 + 연산이 합쳐져 있으면 붙어있는 +끼리만 연산 후 -연산 

< 방법 >
1. StringTokenizer를 -일 때, + 일 때를 나눠서 하면 될듯 -> 실패.. -> hasmoretoken 사용하면될듯
2. 자바 문자열 자르기 -> 검색결과 split
   2-1) split("-")를 써서  -기준으로 나누어 배열에 넣어줌
   2-2) split("+")를 써서 +기준으로 나누어 합을 기존 합에서 빼줌
   2-3) 단, 첫 + 연산값을 초기화해주는 작업이 필요함
 */

import java.io.*;

public class boj_1541 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		// 2-1) split("-")를 써서  -기준으로 나누어 배열에 넣어줌
		String[] m_arr = str.split("-"); // {55, 50+40}
		// 모든 연산 후 가장 작은 값을 넣을 변수 (기존 합)
		int sum = 0;
		
		for(int i = 0; i < m_arr.length; i++) {
			// 왜 오류 나는지.. -> +
			// 2-2) split("+")를 써서 +기준으로 나눔
			String[] p_arr = m_arr[i].split("\\+"); // {(55),(50,40)}
			
			// +기준으로 나눈 값끼리 더한 값을 넣을 변수
			int total = 0;
			// +기준으로 나눈 값끼리 더한 값을 total에 넣어줌
			for(int j = 0; j < p_arr.length; j++) {
				total += Integer.parseInt(p_arr[j]); // 55, (50+40)
			}
			
			// 2-3) 단, 첫 + 연산값을 초기화해주는 작업이 필요함
			if(sum == 0) { // sum을 m_arr배열의 첫번째 원소로 초기화
				sum = total;
			} else { // 2-2) 다음 + 연산끼리의 합을 기존 합에서 빼줌
				sum -= total;
			}
		}
		System.out.println(sum);
	}
}