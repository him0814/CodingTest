package baekjoon;
//น้มุ  1629 ฐ๖ผภ

import java.io.*;
import java.util.*;

public class Multiplication_1629 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		
		System.out.println(check(A,B,C));
	}
	
	public static long check(long A, long B, long C) {
		if(B == 0) {
			return 1;
		} else if(B == 1) {
			return A % C;
		}
		
        long num = check(A, B/2, C);
        
        if(B%2 == 1) {
        	return (num * num % C) * A % C;
        }    
        return num * num % C; 
    }
}
