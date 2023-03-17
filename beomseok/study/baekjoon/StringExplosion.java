package baekjoon;
//백준 9935 문자열 폭발

import java.io.*;

public class StringExplosion {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String explosion = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			sb.append(ch);
			if(sb.length() >= explosion.length()) {
				boolean flag = false;
				for(int j=0; j<explosion.length(); j++) {
					char nch1 = sb.charAt(sb.length() - explosion.length() + j);
					char nch2 = explosion.charAt(j);
					if(nch1 != nch2) {
						flag = true;
						break;
					}
				}
				if(!flag) {
					sb.delete(sb.length() - explosion.length(), sb.length());
				}
			}
		}
		if(sb.length() == 0) {
			System.out.println("FRULA");
		} else if(sb.length() > 0) {
			System.out.println(sb);
		}
	}
}
