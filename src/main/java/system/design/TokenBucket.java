package system.design;

import java.time.Instant;

class TokenBucket {
    private static final double MAX_BUCKET_SIZE = 3.0;
    private static final int REFILL_RATE = 1;

    private double currentBucketSize;
    private long lastRefillTimestamp;

    public TokenBucket() {
        this.currentBucketSize = MAX_BUCKET_SIZE;
        this.lastRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean allowRequest(double tokens) {
        refill(); // Refill the bucket at constant REFILL_RATE

        if (currentBucketSize >= tokens) {
            currentBucketSize -= tokens;
            return true;
        }
        return false;
    }

    private synchronized void refill() {
        long nowTime = System.nanoTime();
        double tokensToAdd = (double) (nowTime - lastRefillTimestamp) * REFILL_RATE / 1e9;
        currentBucketSize = Math.min(currentBucketSize + tokensToAdd, MAX_BUCKET_SIZE);
        lastRefillTimestamp = nowTime;
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucket obj = new TokenBucket();

        System.out.println("Request processed: " + obj.allowRequest(1)); // true
        System.out.println("Request processed: " + obj.allowRequest(1)); // true
        System.out.println("Request processed: " + obj.allowRequest(1)); // true
        System.out.println("Request processed: " + obj.allowRequest(1)); // false, request dropped
    }
}

