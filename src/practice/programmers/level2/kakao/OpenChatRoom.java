package practice.programmers.level2.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChatRoom {
    /**
     * https://programmers.co.kr/learn/courses/30/lessons/42888
     * Programmers 오픈채팅방
     *
     * My Solution :
     * 딱히 알고리즘이라 할 만한 건 없다.
     *
     * Others Solution:
     * 다른사람들의 풀이가 신기했다.
     * 고정적으로 사용하는 문자열을 상수로 선언하기도 하고,
     * 유저 정보나 명령어를 class로 뽑아놓기도 했다.
     * 속도만을 중요시 하던 LeetCode와 달리 유지보수성을 생각한 코드들이 신선했다.
     *
     * Time Complexity : O(n)
     *
     */

    public String[] solution(String[] record) {
        List<String> ans = new ArrayList<>();
        Map<String, String> nickname = new HashMap<>();

        for (String s : record) {
            String[] strings = s.split(" ");
            if (strings[0].equals("Leave")) continue;
            if (!nickname.containsKey(strings[1]))
                nickname.put(strings[1], strings[2]);
            else
                nickname.replace(strings[1], strings[2]);
        }

        for (String s : record) {
            String[] strings = s.split(" ");
            if (strings[0].equals("Enter"))
                ans.add(nickname.get(strings[1]) + "님이 들어왔습니다.");
            else if (strings[0].equals("Leave"))
                ans.add(nickname.get(strings[1]) + "님이 나갔습니다.");
        }


        return ans.toArray(new String[ans.size()]);
    }
}
