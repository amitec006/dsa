package org.example.dsa1.hashing;

import java.util.HashMap;
import java.util.Map;

public class SubArrayCountWithSumB {
    /**
     * Given an array of integers A and an integer B.
     * Find the total number of subarrays having sum equals to B.
     */
    public static void main(String[] args) {
        int[] A = {-42,-30,-8,9,10,-28,22,-35,-10,-41,-16,31,36,-18,43,-45,40,-38,-31,-12,-48,32,9,43,37,18,-14,-8,37,-20,-47,-26,-9,-22,-41,24,-39,9,34,35,-49,-26,-26,-3,-11,-37,43,-9,36,32,45,3,20,26,44,31,22,26,-19,48,32,46,40,-4,27,4,-3,-50,-10,-28,15,41,-19,-27,-44,-22,43,0,35,-36,0,45,-26,-24};
        int B = -24;

        //int[] A = {1, 0, 1};
        //int B = 1;
        System.out.println(new SubArrayCountWithSumB().solve(A, B));
    }

    public int solve(int[] A, int B) {
        Map<Long,Long> map = new HashMap<>();
        map.put(0L,1L);
        long sum = 0;
        long count = 0;
        for (int i : A){
            sum += i;
            if (map.containsKey(sum - B)){
                count += map.get(sum - B);
            }
            map.put(sum, map.getOrDefault(sum, 0L) + 1);
        }
        return (int)count;
    }
}
