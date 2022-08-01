package BaekJoon;

// 첫번째줄 정수 k
// 수의 합 구하기
// 0을 외치면 이전 숫자 삭제 0일 경우 지울 수가 있음 보장

import java.util.*;
import java.io.*;

public class zero {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(bf.readLine());
		Stack<Integer> s = new Stack<>();
		
		for(int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			if(n==0) {
				s.pop();
			} else {
				s.push(n);
			}
		}
		int n = s.size();
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += s.pop();
		}
		System.out.print(sum);
	}
}