package practice.leetcode;

public class MultiplyStrings {
    /**
     * https://leetcode.com/problems/multiply-strings/
     * LeetCode 43. Multiply Strings
     *
     * Solution :
     * 직접 손으로 계산하는 것 처럼 곱한다
     *
     * result : 3ms
     */

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        if ("1".equals(num1)) return num2;
        if ("1".equals(num2)) return num1;

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                product += result[i + j + 1];

                result[i + j + 1] = product % 10;
                result[i + j] += product / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            if (sb.length() == 0 && r == 0) {
                continue;
            }
            sb.append(r);
        }

        return sb.toString();
    }
}
