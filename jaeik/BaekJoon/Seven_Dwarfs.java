package BaekJoon;

import java.util.*;
import java.io.*;

public class Seven_Dwarfs {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarf = new int[9];
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		for(int i = 0; i < 9; i++) {
			int n = Integer.parseInt(br.readLine());
			dwarf[i] = n;
			sum += n;
		}
		
		Arrays.sort(dwarf);
		
		int index1 = 0;
		int index2 = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = i + 1; j < 9; j++) {
				if(sum - dwarf[i] - dwarf[j] == 100) {
					index1 = i;
					index2 = j;
					break;
				}
			}
		}
		for(int k = 0; k < 9; k++) {
			if(k != index1 && k != index2) {
				sb.append(dwarf[k]).append("\n");
			}
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}
}
