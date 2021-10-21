package practice.leetcode;

import java.util.*;

public class InsertDeleteGetRandomO1 {
    /**
     * https://leetcode.com/problems/insert-delete-getrandom-o1/
     * LeetCode 380. Insert Delete GetRandom O(1)
     *
     * Solution :
     * getRandom()을 O(1)의 속도로 처리하기 위해 입력된 숫자들을 list로 관리하고
     * random한 index의 숫자를 뽑도록 한다.
     * 하지만 list 하나만으론 insert와 remove의 복잡도가 O(n)이 된다.
     * 따라서 각 숫자들이 list의 어느 index에 저장되어 있는지 기록하기 위해 map을 사용한다.
     *
     * random 떄문인지 런타임 시간이 들쭉날쭉 하다.
     *
     * Time Complexity : O(1)
     * result : 21-50ms
     *
     */

    class RandomizedSet {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        Random random = new Random();

        public RandomizedSet() {}

        public boolean insert(int val) {
            if (hashMap.containsKey(val)) return false;
            hashMap.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!hashMap.containsKey(val)) return false;
            int index = hashMap.get(val);
            if (index != list.size() - 1) {
                int lastVal = list.get(list.size() - 1);
                list.set(index, lastVal);
                hashMap.put(lastVal, index);
            }
            list.remove(list.size() - 1);
            hashMap.remove(val);

            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
