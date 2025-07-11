package org.example.dsa1.math;

public class PairSumDivisibleByM {
    /**
     * Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
     *
     * Since the answer may be large, return the answer modulo (109 + 7).
     *
     * Note: Ensure to handle integer overflow when performing the calculations.
     *
     */
    public static void main(String[] args) {
        int[] A = {5227,5591,7559,7295,6601,8018,7494,7065,2734,4622,9509,5980,8169,9935,1695,5601,6002,2459,1865,4132,5184,9299,7692,3640,1325,5321,5172,4303,7442,8568,8884,6955,5526,6978,5817,4089,9293,9128,7466,2160,9970,8618,3245,5421,2528,3939,9225,8783,2347,1146,8651,7187,5866,9409,4703,2730,7465,5582,4471,5394,8423,8273,2171,6521,9551,8444,2251,9357,5788,1546,8086,4851,7826,9313,5690,3613,3604,9791,5988,3371,9359,3959,2937,3571,9745,1261,5030,1740,8432,7702,6459,4079,2507,5715,6572,5339,3952,9913,8035,9411,8427,8898,9532,4208,9642,4823,6702,2380,2589,8021,6448,3082,5014,3046,8728,9567,3587,7742,5423,8607,2394,2461,8895,7857,8488,8443,7413,8080,2491,7400,9707,4797,9435,4844,5535,3340,9264,7255,2289,6460,2786,6233,3345,3613,7092,7961,6091,2813,2885,1843,6278,9449,3507,4976,5668,3799,2873,4179,5677,4068,8988,4696,3142,8614,7156,8299,4127,6748,7565,5445,2137,8886,1399,4371,7016,2051,1253,4464,2262,2757,7208,3016,6516,2047,6552,9558,4456,8061,1827,8225,4440,5823,9525,9298,2772,2080,7538,9892,5646,9925,5210,1958,3396,5621,9589,7253,5946,9544,6372,5581,5985,9349,2817,4746,9703,4571,7833,9834,1638,9634,1330,5102,6557,8846,2906,3586,8054,9362,9873,8676,9982,9208,6673,7332,2707,3442,2763,3332,1594,3208,7106,5906,4108,6985,3526,3395,5428,3556,1310,3120,4442,6362,9606,9459,5604,7663,6360,8257,8185,3636,3773,6093,8082,4886,8503,9563,1491,3072,8130,8737,9451,6303,5738,1160,3427,6707,3811,2287,6934,3128,4001,6034,1360,7197,9795,3214,6064,5117,9488,4005,7083,4422,4416,2185,2698,6548,7844,8855,4476,2569,5492,5530,8351,8638,4245,9994,2781,9650,6168,9048,9986,4488,2615,9364,6802,9706,5876,9963,9765,5903,2475,8454,5596,6144,9023,3055,4393,4682,4194,9612,2478,2951,1298,8245,9039,6240,6633,8045,3397,8735,5728,8184,8002,5631,1448,7188,9003,6832,7840,9619,4572,3359,6543,2331,3979,7955,9596,3578,2784,7539,3430,5678,2441,7088,5938,6655,7984,7271,5512,8243,3484,1615,4113,7930,9427,3330,9524,1243,1180,4904,1113,8318,9324,4510,7651,1906,6608,9811,7906,8366,3050,8221,6072,3836,5711,2831,4292,9796,6440,4189,6929,8366,4081,5878,7550,8329,3359,6362,2982,7542,5945,7894,8229,2567,4016,3354,9450,7669,1953,1787,5726,9977,1680,8047,6794,4547,6572,2398,9526,2244,4759,2168,3444,3845,8146,4483,9228,7570,8430,5984,6728,2241,2950,3924,8749,8646,6251,1404,7493,9257,7800,9656,6315,5378,9475,6144,5199,2942,2028,3008,2141,1641,7961,4759,3463,2823,3905,1464,9912,1577,6921,2662,7315,4758,2807,8028,5440,4247,5915,3477,1680,1638,1714,7699,9157,5660,4795,9312,9832,1068,3836,3763,6278,1465,6536,1803,8811,7454,4446,7876,4799,3845,7150,8048,3093,1142,6239,8160,2695,7390,1124,6735,1972,3546,6767,4788,6942,2993,6068,8112,8442,4382,7785,6781,6249,6056,4519,4604,3567,6465,8563,2984,8634,4525,9090,4205,2597,4693,1485,3450,5207,4556,9408,9973,9336,6153,8498,6700,2806,2844,2534,9231,3509,2489,1231,2584,9354,4892,4798};
        int B = 110;
        System.out.println(new PairSumDivisibleByM().solve(A,B)); // 4
    }

    public int solve(int[] A, int B) {
        // Create a frequency array to count
        // occurrences of all remainders when
        // divided by K
        int freq[] = new int[B];

        // Count occurrences of all remainders
        for (int j : A) ++freq[j % B];

        // If both pairs are divisible by 'K'
        int sum = freq[0] * (freq[0] - 1) / 2;

        // count for all i and (k-i)
        // freq pairs
        for (int i = 1; i <= B / 2 && i != (B - i); i++)
            sum += freq[i] * freq[B - i];
        // If K is even
        if (B % 2 == 0)
            sum += (freq[B / 2] * (freq[B / 2] - 1) / 2);
        return sum;
    }

    public int solve2(int[] A, int B) {
        long[] freq = new long[B];
        for (int j : A) {
            freq[j % B]++;
        }

        int i = 1;
        int j = B - 1;
        long ans = freq[0] * (freq[0] - 1) / 2;
        int modulo = 1000000007;
        while (i <= j) {
            if (i == j) {
                ans = ans%modulo + ((freq[i] * (freq[i] - 1)) / 2)%modulo;
            } else {
                ans = ans%modulo + (freq[i] * freq[j])%modulo;
            }
            i++;
            j--;
        }
        return (int)ans%modulo;
    }

    /*Create a frequency array mod[B], where mod[i] is the count of numbers with remainder i when divided by B.
    *
    *For each valid remainder pair (i, j) such that (i + j) % B == 0, count the number of combinations:
    *
    *If i == j, use combination formula: mod[i] * (mod[i] - 1) / 2
    *
    *If i + j == B, use: mod[i] * mod[B - i]
    */


    /**
     *
     *1. Pairs with remainder 0
     *
     * count += (mod[0] * (mod[0] - 1)) / 2;
     * Explanation:
     *
     * Any two numbers whose remainders are both 0 (i.e., divisible by B) will always have a sum divisible by B.
     *
     * So we find how many such numbers exist: mod[0].
     *
     * Then we compute how many unique pairs can be formed from them using combination formula:
     *
     * 📌 Example:
     * If mod[0] = 3 (i.e., 3 numbers divisible by B),
     * n * (n - 1) / 2
     *
     * then total such pairs = 3 * (3 - 1) / 2 = 3.
     *
     * 🔹2. Pairs with remainder i and B - i
     *
     * for (int i = 1; i <= B / 2; i++) {
     *     if (i != B - i) {
     *         count += mod[i] * mod[B - i];
     *     }
     * }
     * Explanation:
     *
     * If one number has remainder i, and another has remainder B - i, then:
     *
     * (i+(B−i))%B=B%B=0
     * → So their sum is divisible by B.
     *
     * ✅ So we pair elements from mod[i] and mod[B - i].
     *
     * 📌 Example:
     * If B = 5, and:
     *
     * mod[1] = 2 (2 numbers with remainder 1)
     *
     * mod[4] = 3 (3 numbers with remainder 4)
     * → Total valid pairs = 2 * 3 = 6
     *
     * The if (i != B - i) is used to avoid double-counting and special case.
     *
     * 🔹3. Handle the middle remainder if B is even
     *
     * if (B % 2 == 0) {
     *     count += (mod[B / 2] * (mod[B / 2] - 1)) / 2;
     * }
     * Explanation:
     *
     * When B is even, there’s a special case for remainder B / 2.
     * For example: if B = 6, then B/2 = 3.
     * → So mod[3] contains numbers with remainder 3.
     *
     * If you pair two such numbers:
     * 3 + 3 = 6 → divisible by 6
     *
     * So again, use combination formula for choosing 2 out of mod[B/2] elements:
     *
     * mod[B/2]⋅(mod[B/2]−1)
     *
     * 📌 Example:
     * If mod[3] = 4,
     * then valid pairs = 4 * (4 - 1) / 2 = 6
     *
     * This part only applies when B is even.
     *
     * 🔁 Why this separation?
     * We must avoid double-counting (e.g., pairing mod[1] with mod[4] and then also mod[4] with mod[1])
     *
     * And we must handle special cases like mod[0] and mod[B/2] using combinations because they pair within themselves.
     * */
    public int countDivisiblePairs(int[] A, int B) {
        int[] mod = new int[B];
        for (int a : A) {
            int r = a % B;
            if (r < 0) r += B; // handle negative values
            mod[r]++;
        }

        int count = 0;
        // Pairs with remainder 0
        count += (mod[0] * (mod[0] - 1)) / 2;

        // Pairs with remainder i and B - i
        for (int i = 1; i <= B / 2; i++) {
            if (i != B - i) {
                count += mod[i] * mod[B - i];
            }
        }

        // If B is even, handle the midpoint remainder separately
        if (B % 2 == 0) {
            count += (mod[B / 2] * (mod[B / 2] - 1)) / 2;
        }

        return count;
    }
}
