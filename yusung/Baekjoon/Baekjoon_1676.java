package Baekjoon;

//백준 1676번 팩토리얼 0의 개수

import java.io.*;

public class Baekjoon_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 1~4 -> 0
        // 5~9 -> 1
        // 10~14 -> 2
        // 15~19 -> 3
        // 20~24 -> 4
        // 25~29 -> 6
        int cnt = 0;
        while(true){
            if(N<5){
                break;
            }
            cnt+=N/5;
            N /=5;
        }
        System.out.println(cnt);

    }
}
