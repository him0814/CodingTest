package BaekJoon;

import java.util.*;
import java.io.*;
public class Number_Continuation {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		for(int i = 1; i <= n; i++) {
			int tmp = i;
			while(tmp > 0) {
				count++;
				tmp /= 10;
			}
		}
		System.out.println(count);
	}
}