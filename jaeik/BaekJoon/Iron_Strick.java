package BaekJoon;

import java.util.*;
import java.io.*;

public class Iron_Strick {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> sta = new Stack<>();
		String s = br.readLine();
		int result = 0;
		boolean tmp = true;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				sta.push(1);
				tmp = true;
			} else {
				if(tmp) {
					sta.pop();
					result += sta.size();
				}
				else {
					sta.pop();
					result++;
				}
				tmp = false;
			}
			
		}
		
		System.out.println(result);
	}
}
