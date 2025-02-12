package Day08.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
// ArrayList가 느린 이유는 0번 인덱스에 새로운 객체가 추가되면서
// 객체의 인덱스를 한칸씩 뒤로 미루는 작업을 수행하기 떄문이다.
public class LinkedListEx {
    public static void main(String[] args) {
        // ArrayList 컬렉션 객체 생성
        List<String> list1 = new ArrayList<>();

        // LinkedList 컬렉션 객체 생성
        List<String> list2 = new LinkedList<>();

        // 시작시간, 종료시간을 저장할 변수 선언
        long startTime;
        long endTime;

        // ArrayList 컬렉션에 저장하는 시간 측정
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list1.add(0,String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n","ArrayList 걸린 시간 ",(endTime - startTime));

        // LinkedList 컬렉션에 저장하는 시간 측정
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list2.add(0,String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n","LinkedList 걸린 시간 ",(endTime - startTime));
    }
}
