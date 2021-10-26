package practice.programmers.level2.hash;

import java.util.Arrays;
import java.util.HashMap;

public class PhoneNumberList {
    /**
     * https://programmers.co.kr/learn/courses/30/lessons/42577
     * Programmers 전화번호 목록
     *
     * Solution :
     * 배열을 정렬한 뒤 앞에 부터 두 개씩 검사한다.
     * 처음엔 substring으로 비교하기 위해 string의 길이 순으로 정렬 한뒤
     * 완전 탐색을 실시 했지만, 효율성 검사를 통과하지 못했다.
     *
     * 그냥 배열 자체를 정렬해 두면 길이도, 완전 탐색을 할 필요도 없어지니 훨씬 빨르게 풀 수 있다.
     * 의외인 점은 hash를 사용한 것이 약간 더 느리다는 것
     *
     * Time Complexity : O(nlogN)
     *
     */

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i]))
                return false;
        }

        return true;
    }

    public boolean hashSolution(String[] phone_book) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length; i++)
            hashMap.put(phone_book[i], i);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].length() < phone_book[i].length()) continue;
            String temp = phone_book[i + 1].substring(0, phone_book[i].length());
            if (hashMap.containsKey(temp) && hashMap.get(temp) != i + 1)  return false;
        }

        return true;
    }
}
