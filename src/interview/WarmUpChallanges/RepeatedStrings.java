package interview.WarmUpChallanges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedStrings {
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        long whole = n / s.length();
        int remainder = (int) (n % s.length());
        long found = 0;

        for (char ch : s.toCharArray()){
            if (ch == 'a') found++;
        }

        long total = found * whole;

        if (remainder == 0) {
            return total;
        } else {
            String part = s.substring(0, remainder);
            for (char ch : part.toCharArray()) {
                if (ch == 'a'){
                    total++;
                }
            }
        }
        return total;

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
