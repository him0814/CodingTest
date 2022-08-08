package BaekJoon;

// 물 새는 곳 N과 테이프 길이 L
// 둘째 줄에 물이 새는 곳 N L 은 1000보다 작거나 같은 자연수
import java.util.*;
import java.io.*;

public class Repairman {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		
		int[] arr = new int[1001];
		Arrays.fill(arr, 0);
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(n > max) {
				max = n;
			}
			arr[n] = 1;
		}
		
		int count = 0;
		
		for(int i = 1; i <= max; i++) {
			if(arr[i] == 1) {
				for(int j = 0; j < L; j++) {
					if(i + j <= max) {
						arr[i+j] = 0;
					}
				}
				count++;
			}
		}
		
		System.out.println(count);
	}
}
