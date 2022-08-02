import java.util.*;
import java.io.*;
import java.util.Map.Entry;


public class Set_Explanation {
    public static void main(String[] args) throws IOException{
        // 1. ����
        Set<String> hs = new HashSet<>(); // �ߺ��� ������� �ʰ� ������ �������� �ʴ´�.
        Map<String, Integer> hm = new HashMap<>();
        hm.put("������", 1);
        hm.put("������1", 2);
        hm.put("������2", 3);
        for(Entry<String, Integer> entryHm : hm.entrySet()) {
            System.out.println(entryHm.getKey() + " : " + entryHm.getValue());
        }

        // 2. ����
        hs.add("������");
        hs.add("������");
        hs.add("������");
        hs.add("�Ź���");
        hs.add("ȫ�浿");
        hs.add("������");

        // 3. ����
        hs.remove("������");

        // 4. ���
        System.out.println(hs.toString());

        Iterator<String> it = hs.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        for(String str : hs) {
            System.out.print(str + " ");
        }
        System.out.println();

        // �����ϰ� ���� ��
        ArrayList<String> al = new ArrayList<>(hs);
        Collections.sort(al);
        for(String str : al) {
            System.out.print(str + " ");
        }
        System.out.println();

        // 5. �� ���� ����
        System.out.println(hs.contains("������"));
        System.out.println(hs.contains("������"));

        // 6. �� ���� ����
        System.out.println(hs.isEmpty());

        // 7. ������ ũ��
        System.out.println(hs.size());
    }
}