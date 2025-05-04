package org.example;

public class Ascii {
    public static void main(String[] args) {
        System.out.println(solve("AmiT"));
    }

    public static String solve(String A) {
        char[] res = A.toCharArray();
        for (int i = 0; i < res.length; i++){
            int ascii_c = res[i];

            int ascii_a = 'a';
            int ascii_z = 'z';

            int ascii_A = 'A';
            int ascii_Z = 'Z';
            if (ascii_c >= ascii_A && ascii_c <= ascii_Z) {
                ascii_c += ascii_a - ascii_A;
                res[i] = (char)ascii_c;
            } else if (ascii_c >= ascii_a && ascii_c <= ascii_z) {
                ascii_c -= ascii_a - ascii_A;
                res[i] = (char)ascii_c;
            }

        }
        return new String(res);
    }
}
