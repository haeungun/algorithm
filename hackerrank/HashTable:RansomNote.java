/**
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 */


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

enum Answer {
    YES("Yes"),
    NO("No");

    private String print;

    Answer(String print) {
        this.print = print;
    }

    public String getPrint() {
        return print;
    }
}

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> dic = new HashMap<>();
        for (String m : magazine) {
            int count = dic.getOrDefault(m, 0);
            dic.put(m, ++count);
        }

        Answer answer = Answer.YES;
        for (String n : note) {
            if (!dic.containsKey(n)) {
                answer = Answer.NO;
            } else {
                int count = dic.get(n);
                if (--count < 0) answer = Answer.NO;
                dic.put(n, count);
            }
        }

        System.out.println(answer.getPrint());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
