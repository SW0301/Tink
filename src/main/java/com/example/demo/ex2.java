package com.example.demo;

//73 96 73 65 67 8  376


import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum1 = 0;
        int sum2 = 0;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[j] % arr[i] != 0) sum1 += arr[j] - arr[j] % arr[i];
                else sum1 += arr[j];
            }
            if (sum2 < sum1) {
                sum2 = sum1 + sum2;
                sum1 = sum2 - sum1;
                sum2 = sum2 - sum1;
            }
            sum1 = 0;
        }
        System.out.println(sum2);
    }
}
