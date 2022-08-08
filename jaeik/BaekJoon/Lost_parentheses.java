package BaekJoon;
//1541

import java.io.*;
import java.util.*;
public class Lost_parentheses {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		List<String> al = new ArrayList<>();
		while(st.hasMoreTokens()) {
			al.add(st.nextToken());
		}
		List<Integer> al2 = new ArrayList<>();
		for(String s : al) {
			st = new StringTokenizer(s, "+");
			int result = 0;
			while(st.hasMoreTokens()) {
				int tmp = Integer.parseInt(st.nextToken());
				result += tmp;
			}
			al2.add(result);
		}
		
		int sum = al2.get(0) * 2;
		
		for(int i : al2) {
			sum -= i;
		}
		
		System.out.print(sum);
	}
}
