package baekjoon;
//น้มุ 9251 LCS

import java.io.*;

public class LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int[][] arr = new int[str1.length()+1][str2.length()+1];
		for(int i=0; i<=str1.length(); i++) {
			for(int j=0; j<=str2.length(); j++) {
				if(i == 0 || j == 0) {
					arr[i][j] = 0;
				}else if(str1.charAt(i-1) == str2.charAt(j-1)) {
					arr[i][j] = arr[i-1][j-1] + 1; 
				} else {
					arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
		System.out.println(arr[str1.length()][str2.length()]);
	}
}
