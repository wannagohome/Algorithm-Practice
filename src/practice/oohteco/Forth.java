package practice.oohteco;

import java.util.*;

public class Forth {
    public int[] number1(int[] arr) {
        int[] answer = new int[3];
        int count1 = 0, count2 = 0, count3 = 0;
        for (int i : arr) {
            if (i == 1) count1++;
            else if (i == 2) count2++;
            else if (i == 3) count3++;
        }

        int max = Math.max(Math.max(count1, count2), count3);
        answer[0] = max - count1;
        answer[1] = max - count2;
        answer[2] = max - count3;

        return answer;
    }

    public String number2(String[] log) {
        int total = 0;
        for (int i = 0; i < log.length / 2; i++) {
            String[] start = log[i * 2].split(":");
            String[] end = log[(i * 2) + 1].split(":");

            int startHour = Integer.parseInt(start[0]);
            int startMin = Integer.parseInt(start[1]);
            int endHour = Integer.parseInt(end[0]);
            int endMin = Integer.parseInt(end[1]);

            int studyMinutes = (endHour - startHour) * 60 + (endMin - startMin);
            if (studyMinutes < 5) continue;
            total += Math.min(105, studyMinutes);
        }

        return String.format("%02d", total / 60) + ":" + String.format("%02d", total % 60);
    }

    public int number3(String[] ings, String[] menu, String[] sell) {
        int answer = 0;
        Map<String, Integer> ingredients = new HashMap<>();
        Map<String, Integer> menus = new HashMap<>();

        for (String ing : ings) {
            ingredients.put(ing.split(" ")[0], Integer.parseInt(ing.split(" ")[1]));
        }

        for (String s : menu) {
            String[] arr = s.split(" ");
            String name = arr[0];
            String ing = arr[1];
            Integer price = Integer.parseInt(arr[2]);

            Integer cost = 0;
            for (char c : ing.toCharArray()) {
                cost += ingredients.get(String.valueOf(c));
            }

            menus.put(name, price - cost);
        }

        for (String s : sell) {
            String[] arr = s.split(" ");
            answer += menus.get(arr[0]) * Integer.parseInt(arr[1]);
        }

        return answer;
    }

    public int[] number4(String s) {
        List<Integer> list = new ArrayList<>();
        int lastCount = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            lastCount++;
            if (s.charAt(i) != s.charAt(i + 1)) {
                list.add(lastCount);
                lastCount = 0;
            }
        }
        if (s.charAt(s.length() - 1) == s.charAt(s.length() - 2)) {
            lastCount++;
            list.add(lastCount);
        } else {
            list.add(1);
        }

        if (s.charAt(s.length() - 1) == s.charAt(0)) {
            list.set(0, list.get(0) + list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }

        return Arrays.stream(list.toArray(Integer[]::new))
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }

    public int[][] number5(int rows, int columns) {
        int[][] answer = new int[rows][columns];
        int zeroCount = rows * columns;
        int num = 1;
        int r = 0, c = 0;

        while (zeroCount > 0) {
            if (answer[r][c] != 0 && answer[r][c] % 2 == num % 2) break;
            if (answer[r][c] == 0) zeroCount--;
            answer[r][c] = num;


            if (num % 2 == 0) r++;
            else c++;
            if (r == rows) r = 0;
            if (c == columns) c = 0;
            num++;
        }

        return answer;
    }

    public String number6(double time, String[][] plans) {
        String answer = "";

        for (String[] plan : plans) {
            int departure = Integer.parseInt(plan[1].substring(0, plan[1].length() - 2));
            int arrival = Integer.parseInt(plan[2].substring(0, plan[2].length() - 2));
            if (plan[1].contains("P")) departure += 12;
            if (plan[2].contains("P")) arrival += 12;

            int timeNeed = 0;
            if (departure < 18) timeNeed += 18 - departure;
            if (arrival > 13) timeNeed += arrival - 13;

            if (time > timeNeed) {
                time -= timeNeed;
                answer = plan[0];
            }
        }

        return answer;
    }

    public String[] number7(String[] grid, boolean clockwise) {
        String[] answer = new String[grid.length];

        for (int i = 0; i < grid[grid.length - 1].length(); i += 2) {
            StringBuilder s = new StringBuilder();
            int row = grid.length - 1;
            int column = i;

            for (int j = 0; j < i + 1; j += 2) {
                s.append(grid[row].charAt(column));
                if (column == 0) break;

                s.append(grid[row].charAt(column - 1));
                row--;
                column -= 2;
            }
            answer[i / 2] = s.toString();
        }

        return clockwise ? answer : number7(answer, true);
    }
}
