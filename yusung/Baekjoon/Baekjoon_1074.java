package Baekjoon;

//백준 1074번 Z

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1074 {
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int sq = (int)Math.pow(2,N);
        sol(r,c,sq);
        System.out.println(res);

    }

    private static void sol(int r, int c, int sq) {
        if(sq == 1){
            return;
        }
        int size = sq/2;

        //1사분면
        if(r<size && c>=size){
            res += size*size*1;
            sol(r,c-size,size);

        }

        //2사분면
        else if(r<size && c<size){
            res += size*size*0;
            sol(r,c,size);
        }

        //3사분면
        else if(r>=size && c<size){
            res += size*size*2;
            sol(r-size,c,size);

        }

        //4사분면
        else if(r>=size && c>=size){
            res += size*size*3;
            sol(r-size,c-size,size);
        }

    }
}
