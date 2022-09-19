package BOJ;

/*
백준 #3986
좋은 단어 찾기
좋은 단어 : 글자 위 아치형 곡선을 그어 안 겹치면 좋은단어
문자열이 좋은 단어 기준 대칭이 되면 좋은단어 -> stack으로 풀면 될듯
 */

import java.io.*;
import java.util.*;

public class boj_3986 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_cnt = Integer.parseInt(br.readLine());
		int count = 0;
		
		for (int i = 0; i < test_cnt; i++) {
			
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			
			for(int j = 0; j < str.length(); j++) {
				// 처음 삽입된 문자(peek())와 다음 문자를 비교해 같으면 pop() 다르면 push()
				if(!stack.isEmpty() && stack.peek() == str.charAt(j)) {
					stack.pop();
				} else { // stack.peek() != str.charAt(i)
					stack.push(str.charAt(j));
				}
			}
			if(stack.size() == 0) {
				count++;
			}
		}
		sb.append(count);
		System.out.println(count);
	}
}