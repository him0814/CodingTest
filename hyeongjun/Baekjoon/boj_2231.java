package BOJ;

/*
백준 #2231 분해합

0부터 N까지 돌리면서 분해합이 N인 숫자를 찾으면됨
분해합 = N+ N의 각 자리수의 합
 */

import java.io.*;

public class boj_2231 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());

        int answer = 0;

        for(int i = 0; i < num; i++) { // 0~num까지 돌림
            int now = i; // 0~num
            int sum = 0; // i 의 각 자리 수의 합
            
            while(true) {
                if(now == 0) { // now /= 10; 하다보면 몫이 0일때
                    break;
                }
                sum += now % 10; // 각 자리 수의 합
                now /= 10; 
            }

            if(i + sum == num) { 
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
