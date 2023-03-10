package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 1451 직사각형으로 나누기
public class Baekjoon_1451 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr2 = new int[N][M];

		for (int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			
			for(int j=0; j < M; j++) {
				arr2[i][j] = arr[j] - '0';
			}
		}
		 long max = 0;
	        
	        for(int i = 1; i < N; i++) {
	            long a = getRectangleSum(0, i, 0, M, arr2);
	            
	            for(int j = 1; j < M; j++) {
	                long b = getRectangleSum(i, N, 0, j, arr2);
	                long c = getRectangleSum(i, N, j, M, arr2);
	                
	                long tmp = a * b * c;
	                
	                if(max < tmp) {
	                    max = tmp;
	                }
	            }
	            
	            for(int j = i + 1; j < N; j++) {
	                long b = getRectangleSum(i, j, 0, M, arr2);
	                long c = getRectangleSum(j, N, 0, M, arr2);
	                
	                long tmp = a * b * c;
	                
	                if(max < tmp) {
	                    max = tmp;
	                }
	            }    
	        }
	        
	        for(int i = N - 1; i > 0; i--) {
	            long a = getRectangleSum(i, N, 0, M, arr2);
	            
	            for(int j = 1; j < M; j++) {
	                long b = getRectangleSum(0, i, 0, j, arr2);
	                long c = getRectangleSum(0, i, j, M, arr2);
	                
	                long tmp = a * b * c;
	                
	                if(max < tmp) {
	                    max = tmp;
	                }
	            }
	        }
	        
	        for(int i = 1; i < M; i++) {
	            long a = getRectangleSum(0, N, 0, i, arr2);
	            
	            for(int j = 1; j < N; j++) {
	                long b = getRectangleSum(0, j, i, M, arr2);
	                long c = getRectangleSum(j, N, i, M, arr2);
	                
	                long tmp = a * b * c;
	                
	                if(max < tmp) {
	                    max = tmp;
	                }
	            }
	            
	            for(int j = i + 1; j < M; j++) {
	                long b = getRectangleSum(0, N, i, j, arr2);
	                long c = getRectangleSum(0, N, j, M, arr2);
	                
	                long tmp = a * b * c;
	                
	                if(max < tmp) {
	                    max = tmp;
	                }
	            }    
	        }
	        
	        for(int i = M - 1; i > 0; i--) {
	            long a = getRectangleSum(0, N, i, M, arr2);
	            
	            for(int j = 1; j < N; j++) {
	                long b = getRectangleSum(0, j, 0, i, arr2);
	                long c = getRectangleSum(j, N, 0, i, arr2);
	                
	                long tmp = a * b * c;
	                
	                if(max < tmp) {
	                    max = tmp;
	                }
	            }
	        }
	        
	        System.out.println(max);
	    }
	    
	    private static long getRectangleSum(int sI, int eI, int sJ, int eJ, int[][] rectangle) {
	        long sum = 0;
	        
	        for(int i = sI; i < eI; i++) {
	            for(int j = sJ; j < eJ; j++) {
	                sum += rectangle[i][j];
	            }
	        }
	        
	        return sum;
	}
}
