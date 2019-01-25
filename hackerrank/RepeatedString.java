import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        char[] chars = s.toCharArray();
        int size = chars.length;

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (chars[i] == 'a') count++;
        }

        if (count == 0) return 0;
        
        long p = n / size;
        long q = n % size;

        long amount = p * count;
        for (int i = 0; i < q; i++) {
            if (chars[i] == 'a') amount++;
        }
        return amount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
