package Baekjoon;

//백준 1629번 곱셈

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        System.out.println(sol(a,b,c)%c);

//        long quo = b/2; // 몫
//        long res = a%c;
//        if(b%2 != 0){
//            for(int i=0; i<quo; i++){
//                res = (res*res)%c;
//            }
//            res = ((a%c)*res)%c;
//        }
//        else {
//            for(int i=0; i<quo; i++){
//                res = (res*res)%c;
//            }
//        }
//        System.out.println(res);
    }
    public static long sol(long a, long b, long c){
        if(b==0){
            return 1;
        }
        long n = sol(a, b/2, c)%c;
        if(b%2 != 0){
            return (((n*n)%c)*a)%c;
        }
        else {
            return (n*n)%c;
        }
    }
}
