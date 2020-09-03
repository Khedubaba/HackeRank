package problemsolving.interview.DictionaryAndHashMap;

import java.util.HashMap;
import java.util.Scanner;

public class RansomeNote {
    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        boolean condition = true;

        HashMap<String, Integer> magStrings = new HashMap<>();
        HashMap<String, Integer> noteStrings = new HashMap<>();



        for (String ms : magazine) {
            if (magStrings.containsKey(ms)) {
                magStrings.put(ms, magStrings.get(ms)+1);
            }
            else {
                magStrings.put(ms,1);
            }
        }

        for (String ns : note) {
            if (noteStrings.containsKey(ns)) {
                noteStrings.put(ns, noteStrings.get(ns)+1);
            }
            else {
                noteStrings.put(ns,1);
            }
        }

        for (String key : noteStrings.keySet()) {
            if (!magStrings.containsKey(key) || magStrings.get(key) < noteStrings.get(key)) {
                condition = false;
                break;
            }
        }

        if (condition) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

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
