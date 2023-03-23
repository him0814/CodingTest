package Baekjoon;

//백준 1389번 케빈 베이컨의 6단계 법칙

import java.io.*;
import java.util.*;

public class Baekjoon_1389 {
    static final int INF = 50001;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = 1;
            arr[end][start] = 1;
        }

        // 인접행렬에서 연결안된 -> 0인부분 INF(도달할수없는값)으로 초기화
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                if(i==j){
                    continue;
                }
                if(arr[i][j] == 0){
                    arr[i][j] = INF;
                }
            }
        }

        //플루이드와샬 알고리즘
        //경유지 포문
        for(int k=1; k<=N; k++){
            //출발지 포문
            for(int i=1; i<=N; i++){
                //출발지와 경유지가 같을 때
                if(i==k){
                    continue;
                }
                //도착지 포문
                for(int j=1; j<=N; j++){
                    //출발지와 도착지가 같을떄 또는 경유지와 도착지가 같을때
                    if(i==j || k==j){
                        continue;
                    }
                    //출발지->경유지->도착지 가중치의 합과 출발지->도착지의 가중치의 합을 비교해서 작은값을 넣어줌
                    arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        int answer = 0;
        for(int i=1; i<arr.length;i++){
            int sum = 0;
            for(int j=1; j<arr[i].length; j++){
                if(arr[i][j] == 50001){
                    continue;
                }
                sum+=arr[i][j];
            }
            if(result > sum){
                answer = i;
                result = sum;
            }
        }
        System.out.println(answer);
    }
}
