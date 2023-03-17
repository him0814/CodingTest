package baekjoon;
//πÈ¡ÿ 12904 AøÕB

import java.io.*;

public class AandB {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String T = br.readLine();
		
		while(S.length() != T.length()) {
            StringBuilder sb = new StringBuilder();
			if(T.endsWith("A")) {
				T = T.substring(0, T.length() - 1);
			} else if(T.endsWith("B")) {
				T = T.substring(0, T.length() - 1);
				T = sb.append(T).reverse().toString();
			}
		}
		
		if(S.equals(T)) {
			System.out.print(1);
		} else {
			System.out.print(0);
		} 
	}
}
