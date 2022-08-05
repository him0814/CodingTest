package Baekjoon;

import java.io.*;
import java.util.*;

//백준 16953번 A->B
// A B를 입력받음
//2를 곱하는연산/1을 수의 가장 오른쪽에 추가하는 연산의 횟수 최솟값+1한 값을 리턴/못만드는 경우는 -1리턴
//B부터 확인해서 맨뒤자리가1 -> 10으로 나눴을때 나머지가1일경우랑 2로나눴을때 나머지가 0인경우만 만들수있음

public class Baekjoon_16953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int result = 1;

		while (B != A) {
			
			if (B < A) {//B랑 A랑 같아지면 result+1값 출력하면서 와일문 종료
				result=-1;
				break;
			}	

			if (B % 10 == 1) { //끝자리가 1일때
				B /= 10;
			}
			else if (B % 2 == 0) { // *2연산이 되는 경우
				B /= 2;
			} 			
			else {
				result=-1;
				break;
			}
			
			result++;		
		}
		System.out.println(result); // 애초에 위에 if문 만족안하면 연산불가능한 숫자임
	}
}
