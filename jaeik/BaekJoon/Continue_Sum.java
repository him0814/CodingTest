package BaekJoon;
import java.io.*;
import java.util.*;
public class Continue_Sum {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			int m = Integer.parseInt(st.nextToken());
			sum += m;
			max = Math.max(sum, max);
			
			if(sum < 0) {
				sum = 0;
			}
		}
		System.out.print(max);
	}
}
