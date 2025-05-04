package org.example.dsa1.primenumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IsPrime {
    /**
     * Given a number A. Return 1 if A is prime and return 0 if not.
     *
     * Note :
     * The value of A can cross the range of Integer.
     */
    public static void main(String[] args) {
        //int n = 17;
        //System.out.println(isPrime(n));

        List<Integer> ret = IntStream.rangeClosed(1, 100).boxed().filter(x -> isPrime(x)).collect(Collectors.toList());
        ret.stream().forEach(System.out::println);

    }

    private static boolean isPrime(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    count++;
                } else {
                    count += 2;
                }
                if (count > 2) {
                    return false;
                }
            }
        }
        return (count == 2);
    }

    private static boolean isPrime2(int n) {
        if (n <= 1) return false;
        long count = IntStream.rangeClosed(1, (int) Math.sqrt(n))
                .filter(i -> n % i == 0)
                .count();
        return count == 1;
    }
}
