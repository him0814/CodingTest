package baekjoon;
//백준 17298 오큰수

import java.io.*;
import java.util.*;

public class Okunsoo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			while(!stack.empty() && arr[stack.peek()] < arr[i]) {
				arr[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		
		while(!stack.empty()) {
			arr[stack.pop()] = -1;
		}
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i]).append(' ');
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}
}
