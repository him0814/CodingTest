package BaekJoon;

import java.util.*;
import java.io.*;

public class AtoB {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int count = 1;
		while(A != B) {
			if(A > B) {
				count = -1;
				break;
			}
			
			if(B % 10 == 1) {
				B /= 10;
				count++;
			}
			else if (B % 2 == 1) {
				count = -1;
				break;
			}
			else if (B % 2 == 0) {
				B /= 2;
				count++;
			}
		}
		
		System.out.println(count);
	}
}