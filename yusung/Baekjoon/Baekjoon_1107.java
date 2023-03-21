package Baekjoon;

import java.io.*;
import java.util.*;

//백준 1107번 리모컨

public class Baekjoon_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if(N==100){
            System.out.println(0);
        }
        else{
            if(M!=0){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String[] arr = new String[M];
                for(int i=0; i<arr.length; i++){
                    arr[i] = st.nextToken();
                }
                System.out.println(check(arr,N));
            }
            else{
                if(N==0){
                    System.out.println(Math.min(Math.abs(N-100),1));
                }
                else{
                    System.out.println(Math.min(Math.abs(N-100),(int)(Math.log10(N)+1)));
                }
            }
        }
    }

    public static int check(String[] arr, int N){
        int min = Math.abs(N-100);

        for (int i = N; i >= 0; i--) {
            boolean flag = false;
            String tmp = Integer.toString(i);
            for (int j = 0; j < arr.length; j++) {
                if (tmp.contains(arr[j])) {
                    flag = true;
                }
            }
            if(flag == false){
                min = Math.min(min, N-i+tmp.length());
                break;
            }
        }
        for (int i = N; i <= 1000000; i++) {
            boolean flag = false;
            String tmp = Integer.toString(i);
            for (int j = 0; j < arr.length; j++) {
                if (tmp.contains(arr[j])) {
                    flag = true;
                }
            }
            if(flag == false){
                min = Math.min(min, i-N+tmp.length());
                break;
            }
        }
        return min;
    }
}


