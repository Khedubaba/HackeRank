package problemsolving.interview.ArraysProblems;

import java.util.Scanner;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
//        int size = q.length;
//        int expectedNum = q.length;
//        int numOfBribes = 0;
//        int i = size-1;
//        boolean tooChaotic = false;
//
//        while (i >= 0 && !tooChaotic) {
//            if (q[i] != expectedNum) {
//                int shift = 0;
//                while (i >=0 && q[i] != expectedNum) {
//                    if (shift < 2) {
//                        i--;
//                        shift++;
//                    }
//                    else {
//                        tooChaotic = true;
//                        shift = 0;
//                        break;
//                    }
//                }
//                numOfBribes += shift;
//                i--;
//                expectedNum = expectedNum - shift - 1;
//            }
//            else {
//                i--;
//                expectedNum -= 1;
//            }
//        }
//
//        if (tooChaotic) {
//            System.out.println("Too chaotic");
//        }
//        else {
//            System.out.println(numOfBribes);
//        }

        int swapCount = 0;

        for (int i = q.length - 1; i >=0; i--) {
            if (q[i] != i+1) {
                if (((i-1) >= 0) && q[i-1] == (i+1)) {
                    swapCount ++;
                    swap(q, i-1, i);
                } else if (((i-1) >= 0) && q[i-2] == (i+1)) {
                    swapCount += 2;
                    swap(q, i-2, i-1);
                    swap(q, i-1, i);
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }

        System.out.println(swapCount);

    }

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }

}
