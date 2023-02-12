package com.example.demo;

import java.util.Scanner;
//1234??7890 YES
//11223344550?2?4?6?80?6677889900 YES
//0?2?4?6?802? NO

public class Demo1Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String answ = "NO";
        boolean inter = false;
        char[] carray = str.toCharArray();
        int len = str.length();
        if (len > 9) {
            for (int i = 0; i < len - 9; i++) {
                for (int j = i; j < i + 9; j++) {
                    for (int k = j + 1; k < i + 10; k++) {
                        if (carray[k] != '?' && carray[j] != '?') {
                            if (carray[j] == carray[k]) {
                                inter = true;
                            }
                        }
                    }
                }
                if (!inter) {
                    answ = "YES";
                    System.out.println(answ);
                    return;
                } else inter = false;
            }
        }
        if (answ.equals("NO")) System.out.println(answ);
    }
}


