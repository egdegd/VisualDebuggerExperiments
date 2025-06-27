/*
You are given an implementation of some sorting algorithm.
This algorithm is supposed to sort an array of integers in non-decreasing order.

For example, with the input:
    int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 8};
The expected output is:
    1 2 3 4 5 6 7 8 9
But the actual output is:
    1 2 3 4 5 6 7 9 8

Your Task
    •	Find and fix the bug in the provided code.
    •	Make as few modifications as possible to achieve correct behavior.
    •	Keep the overall structure and logic of the original code.

 */

public class FTask1 {

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] < arr[j]) {
                    var temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }


        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}

