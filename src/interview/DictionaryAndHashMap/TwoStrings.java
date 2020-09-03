package problemsolving.interview.DictionaryAndHashMap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class TwoStrings {
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        HashMap<Character, Character> s1Map = new HashMap<>();
        HashMap<Character, Character> s2Map = new HashMap<>();
        String result = "";

        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();

        for (int i = 0; i < s1.length(); i++) {
            s1Map.put(s1Char[i], s1Char[i]);
        }

        for (int j = 0; j < s2.length(); j++) {
            s2Map.put(s2Char[j], s2Char[j]);
        }

        for (int k = 0; k < s1Char.length; k++) {
            if (s1Map.containsKey(s1Char[k]) == s2Map.containsKey(s1Char[k])) {
                result = "YES";
                break;
            }
            else {
                result = "NO";
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
