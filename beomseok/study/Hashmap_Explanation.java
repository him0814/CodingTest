import java.util.*;
import java.io.*;
// containskey, put, get, foreach(keyset)

public class Hashmap_Explanation {
    public static void main(String[] args) throws IOException{
        HashMap<String, Integer> hm = new HashMap<>();
        // ������ ����
        hm.put("�Ź���", 1);
//        hm.put(100, 1);
        hm.put("������", 1);
        hm.put("������", 2);
        hm.put("������", hm.getOrDefault("������", 0) + 1); // get�� ���� ������ ������ �� + 1, �ƴϸ� 0 + 1
        hm.put("������", 4);

        // ������ ���
        System.out.println(hm.get("������"));
        System.out.println(hm.size());

        // ������ ���� Ȯ�� -> containsKey -> true false
        if(!hm.containsKey("������")) {
            System.out.println(hm.containsKey("������"));
        }

//        for(String str : hm.size()) {
//
//        }

        for(String str : hm.keySet()) {
            if(hm.get("������") == 3) {
                System.out.println("�¾ҽ��ϴ�");
                System.out.println(hm.keySet());
            }
        }

        // 
    }
}