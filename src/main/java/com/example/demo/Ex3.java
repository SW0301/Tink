package com.example.demo;


import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //кол-во телескопов
        int m = sc.nextInt(); // кол-во звезд
        int k = sc.nextInt(); // число режимов
        int[] telescopeModes = new int[n];
        for (int i = 0; i < n; i++) {
            telescopeModes[i] = sc.nextInt();
        }
        int[][] telescopeNumbers = new int[m][2]; //m строк 2 столбца
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < telescopeNumbers[i].length; j++) {
                telescopeNumbers[i][j] = sc.nextInt() - 1;
            }
        }
        sc.close();
        int countMin = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == telescopeNumbers[j][0]) {
                    if (telescopeModes[telescopeNumbers[j][0]] != telescopeModes[telescopeNumbers[j][1]]) {
                        countMin++;
                        telescopeModes[telescopeNumbers[j][1]] = telescopeModes[i];
                    }
                } else if (i == telescopeNumbers[j][1]) {
                    if (telescopeModes[telescopeNumbers[j][0]] != telescopeModes[telescopeNumbers[j][1]]) {
                        countMin++;
                        telescopeModes[telescopeNumbers[j][0]] = telescopeModes[i];
                    }
                }
            }
        }
        System.out.println(countMin);
    }
}
