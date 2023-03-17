package baekjoon;
//น้มุ  1074 Z

import java.io.*;
import java.util.*;

public class Z {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());	
		
		int xLength = (int) Math.pow(2, N) / 2;
		int yLength = xLength;
		int res = 0;
		
		while (N-- > 0) {
			int tmp = (int) Math.pow(2, N) / 2;
			int next = (int) Math.pow(4, N);

			if (r < yLength && c < xLength) {
				xLength -= tmp;
				yLength -= tmp;
			} else if (r < yLength && c >= xLength) {
				xLength += tmp;
				yLength -= tmp;
				res += next;
			} else if (r >= yLength && c < xLength) {
				xLength -= tmp;
				yLength += tmp;
				res += next*2;
			} else {
				xLength += tmp;
				yLength += tmp;
				res += next*3;
			}
		}
		System.out.println(res);
	}
}
