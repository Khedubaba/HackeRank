package problemsolving.interview.ArraysProblems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class MinimumSwap2 {
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        boolean[] isVisited = new boolean[arr.length + 1];
        HashMap<Integer, Integer> mapBlock = new HashMap<Integer, Integer>();

        //hasmap initialized
        for (int i = 1; i < isVisited.length; i++) {
            mapBlock.put(i, arr[i - 1]);
        }

        int countSwap = 0;

        //iterating through hashmap
        for (int k = 1; k <= mapBlock.size(); k++) {
            int nextMapBlock = 0;

            //checking in if block if block is visited or not
            if (!isVisited[k]) {
                isVisited[k] = true;

                if (k == mapBlock.get(k)) {
                    continue;
                } else {
                    int c = mapBlock.get(k);

                    //performing cycle logic in while block
                    while (!isVisited[c]) {
                        isVisited[c] = true;
                        nextMapBlock = mapBlock.get(c);
                        c = nextMapBlock;
                        ++countSwap;
                    }
                }
            }
        }
        return countSwap;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
