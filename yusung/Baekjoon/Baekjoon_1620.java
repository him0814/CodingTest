package Baekjoon;

//백준 1620번 나는야 포켓몬마스터 이다솜

import java.io.*;
import java.util.*;

public class Baekjoon_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> hm1 = new HashMap<>();
        Map<String, Integer> hm2 = new HashMap<>();
        for(int i=0; i<N; i++){
            String str = br.readLine();
            hm1.put(i+1, str);
            hm2.put(str, i+1);
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            String str = br.readLine();
            if(match(str)){
                sb.append(hm1.get(Integer.parseInt(str))).append("\n");
            }
            else{
                sb.append(hm2.get(str)).append("\n");
            }
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
    }

    public static boolean match(String str){
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }
}
