package practice.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    /**
     * https://leetcode.com/problems/unique-email-addresses/submissions/
     * LeetCode 929. Unique Email Addresses
     *
     * My Solution :
     * 설명이 필요 없음
     *
     * Time Complexity : O(n)
     * result : 16ms
     *
     */

    public static void main(String[] args) {
        numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.email.leet+alex@code.com"});
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> result = new HashSet<>();

        for (int i = 0; i < emails.length; i++) {
            String[] arr = emails[i].split("@");
            String localName = arr[0].split("\\+")[0].replace(".", "");
            result.add(localName + "@" + arr[1]);
        }

        return result.size();
    }
}
