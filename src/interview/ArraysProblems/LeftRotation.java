package problemsolving.interview.ArraysProblems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LeftRotation {
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
//        int rot = 0;
//        int[] arr = new int[a.length];
//
//        for (int x = 0; x < a.length; x++) {
//            arr[x] = a[x];
//        }
//
//        while (rot <= d) {
//            int firstNum = 0;
//
//            for (int i = 0; i < arr.length; i++){
//                if (i==0) {
//                    firstNum = arr[0];
//                }
//                else {
//                    arr[i-1] = arr[i];
//                    if (i == arr.length-1){
//                        arr[i] = firstNum;
//                    }
//                }
//            }
//
//            rot++;
//        }
//
//        return arr;

        int[] rotatedArr = new int[a.length];

        int i = 0;
        int rotate_index = d;

        while (rotate_index < a.length) {
            rotatedArr[i] = a[rotate_index];
            i++;
            rotate_index++;
        }

        rotate_index = 0;
        while (rotate_index < d) {
            rotatedArr[i] = a[rotate_index];
            i++;
            rotate_index++;
        }

        return rotatedArr;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
