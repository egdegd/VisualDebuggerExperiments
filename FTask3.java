/*
Problem Description

Given a matrix matrix[][] of size n x n, the task is to print all elements of the matrix in spiral form.

Your Task

You are given a Java implementation that attempts to solve this problem.
However, there is a subtle bug in the code that leads to incorrect results.

For the input:
    int[][] matrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
The expected output is:
    1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
But the program currently prints an incorrect:
    1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 6

Your Task
    •	Find and fix the bug in the provided code.
    •	Make as few modifications as possible to achieve correct behavior.
    •	Keep the overall structure and logic of the original code.

 */


public class FTask3 {
    public static void printCustomSpiral(int[][] matrix) {
        int n = matrix.length;
        int count = 0;
        int total = n * n;

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;

        int i = 0, j = 0;

        while (top <= bottom && left <= right && count < total) {
            i = top;
            for (j = left; j <= right - 1 && count < total; j++) {
                System.out.print(matrix[i][j] + " ");
                count++;
            }
            System.out.print(matrix[i][j] + " ");
            count++;
            top++;


            for (i = top; i <= bottom - 1 && count < total; i++) {
                System.out.print(matrix[i][j] + " ");
                count++;
            }
            System.out.print(matrix[i][j] + " ");
            count++;

            right--;

            for (j = right; j >= left + 1 && count < total; j--) {
                System.out.print(matrix[i][j] + " ");
                count++;
            }
            System.out.print(matrix[i][j] + " ");
            count++;
            bottom--;

            for (i = bottom; i >= top + 1 && count < total; i--) {
                System.out.print(matrix[i][j] + " ");
                count++;
            }
            if(count==total) {
                break;
            }
            System.out.print(matrix[i][j] + " ");
            count++;
            
            left++;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };

        printCustomSpiral(matrix);
    }
}
