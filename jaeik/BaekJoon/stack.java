package BaekJoon;

import java.io.*;
import java.util.*;

public class stack {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<String> s = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			if(str.equals("push")) {
				s.push(st.nextToken());
			} else if(str.equals("pop")) {
				if(s.empty())
					System.out.println("-1");
				else
					System.out.println(s.pop());
			} else if(str.equals("size")) {
				System.out.println(s.size());
			} else if(str.equals("empty")) {
				if(s.empty())
					System.out.println("1");
				else
					System.out.println("0");
			} else if(str.equals("top")) {
				if(s.empty())
					System.out.println("-1");
				else
					System.out.println(s.peek());
			}
		}
	}
}