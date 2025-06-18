import java.util.logging.Logger;

public class Revision {
    public static void main(String[] args) {
        System.out.println(new Revision().factorSum(6) == 6);
    }

    private int func(int n) {
        int s = 0;
        for (int i = 0; i < n; i = i*2){
            s = s+i;
        }
        return s;
    }

    private int factorSum (int num) {
        int sum = 1;
        if (num <= 2) return 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (num / i == i) {
                    sum += i;
                } else {
                    sum += i;
                    sum += num/i;
                }
            }
        }

        return sum;
    }

    private int countPrimeNumber(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int num) {
        return 2 == countFactor(num);
    }

    private int countFactor (int num) {
        int count = 0;

        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (num / i == i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }

        return count;
    }
}
