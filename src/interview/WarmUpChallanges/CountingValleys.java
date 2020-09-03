package interview.WarmUpChallanges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int valleyCount = 0, dent = 0;
        boolean valleyStarted = false;

        for (int i=0; i<n; i++){
            char ch = Character.toUpperCase(s.charAt(i));
            if(ch == 'D'){
                dent--;
                valleyStarted = true;
            }
            else if(ch == 'U'){
                dent++;
                if(dent == 0 && valleyStarted){
                    valleyCount++;
                    valleyStarted = false;
                }
            }
        }
        return valleyCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
