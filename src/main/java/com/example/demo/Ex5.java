package com.example.demo;

//73 96 73 65 67 8  376
//3
//11 19 171
//10000309500

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        long sum1 = 0;
        long sum2 = 0;
        quickSort(arr, 0, n - 1);
        for (int i = 0; i < n/2+1; i++) {
            if (i != n - 1 && arr[i] == arr[i + 1]) {
                sum1 += arr[i];
                i++;
            }
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

    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;
        return i + 1;
    }
}