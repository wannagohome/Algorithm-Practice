package practice.leetcode;

public class ValidParenthesisString {
    /**
     * https://leetcode.com/problems/valid-parenthesis-string/
     * 678. Valid Parenthesis String
     *
     * My Solution : 좌괄호, 별, 우괄호를 단순히 count하여
     * 좌괄호의 count가 0이 아니거나 음수가 될 때 false
     * result : wrong
     *
     * Better Solution :
     * 1. 좌괄호를 +1, 우괄호를 -1, *을 -1, 0, 1로 간주한다
     * 2. 별을 만날 때마다 세갈래로 분기가 나뉘지만 각 수들을 종합해 보았을 때
     *    결국 전 번의 경우의 수에 최대값이 +1, 최소값이 -1 된것 뿐이다.
     *    (나머지 경우의 수는 모두 겹쳐짐)
     * 3. 최소값은 양수일 때만 1을 뺀다. 최소값이 음수가 되는 case 는
     *    이미 broke 상태로 이후의 count 로 완벽한 문장이 되도록
     *    판정이 나는 것을 방지한다.
     * result: 0ms
     */

    public static void main(String[] args) {
        System.out.println(solution("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
    }

    public static boolean solution(String s) {
        int high = 0;
        int low = 0;

        for(char c: s.toCharArray()) {
            switch (c) {
                case '(':
                    high++; low++;
                    break;
                case ')':
                    if (low > 0) low--;
                    high--;
                    break;
                case '*':
                    if (low > 0) low--;
                    high++;
                    break;
                default:
                    break;
            }
            if (high < 0) return false;
        }

        return low == 0;
    }
}
