package baekjoon;
// 백준 제로 10773

//재현이 잘못된 수 부를 때 마다 0, 재민이 쓴 수 지움  ㅡ> 돈을 부르면 push, 0이면 pop
//그렇게 받아적은 모든 수 합 출력

//첫번째 줄: 정수 K(1 ≤ K ≤ 100,000)
//이후: K개 줄 만큼 정수 1개씩

import java.io.*;
import java.util.*;

public class Zero_That_Out {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<k; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				stack.pop();
			else
				stack.push(n);
		}
		int sum = 0;
		for(int r : stack) {
			sum +=r;
		}
		System.out.println(sum);
	}
}
