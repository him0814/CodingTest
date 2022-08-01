package Baekjoon;

import java.util.*;
import java.io.*;

//백준 10773번 제로

public class Baekjoon_10773 {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int k = Integer.parseInt(br.readLine());		
		
		for(int i=0; i<k; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				stack.pop();
			}
			else {
				stack.push(n);				
			}
		}
		
		int sum=0;
		for(int i=stack.size(); i>0; i--) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
}
