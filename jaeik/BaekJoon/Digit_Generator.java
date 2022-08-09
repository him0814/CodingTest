package BaekJoon;

// 첫째 줄에 자연수 1 <= N <= 1,000,000

import java.util.*;
import java.io.*;

public class Digit_Generator {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = N;
		int count = 1;
		while(M > 10) {
			M /= 10;
			count *= 10;
		}
		
		int tmp = M * count;
		
		
		if(N - tmp > 100) {
			while(tmp < N) {
				int ctmp = count;
				int tmp2 = tmp;
				int sum = tmp;
				while(ctmp != 1) {
					sum += tmp2 / ctmp;
					tmp2 = tmp2 % ctmp;
					ctmp /= 10;
				}
				sum += tmp2;
				if(sum == N) {
					break;
				}
				tmp++;
			}
		}
		else {
			if(tmp >= 100) {
				tmp = tmp - count;
				while(tmp < N) {
					int ctmp = count;
					int tmp2 = tmp;
					int sum = tmp;
					while(ctmp != 1) {
						sum += tmp2 / ctmp;
						tmp2 = tmp2 % ctmp;
						ctmp /= 10;
					}
					sum += tmp2;
					if(sum == N) {
						break;
					}
					tmp++;
				}
			}
			else {
				tmp = 0;
				while(tmp < N) {
					int ctmp = count;
					int tmp2 = tmp;
					int sum = tmp;
					while(ctmp != 1) {
						sum += tmp2 / ctmp;
						tmp2 = tmp2 % ctmp;
						ctmp /= 10;
					}
					sum += tmp2;
					if(sum == N) {
						break;
					}
					tmp++;
				}
			}
			
		}
		if(tmp == N) {
			tmp = 0;
		}
		System.out.print(tmp);
	}
}
