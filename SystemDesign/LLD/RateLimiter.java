/*
 * // Features
1. Different Rate Limiting Configurations
2. Different Rate Limiting Algorithms (Algos Token Bucket, Leaky Bucket, Sliding Window, Sliding Window Log)
3. Rate Limiting at User Level / IP Level/ API endpoints level
4. Thread Safe Implementation
5. Distributed Rate LimiterImplementation (Using Redis to store the counter values)
 */

// Design Patterns Used:
/*
1. Strategy Pattern : For Scoring Strategy
 */

interface RateLimitingAlgorithm {
    boolean isAllowed(Bucket bucket);
}

class Bucket {
    int tokens;
    long lastRefillTime;

    public Bucket(int capacity) {
        this.tokens = capacity;
        this.lastRefillTime = System.currentTimeMillis();
    }
}

class TokenBucketAlgorithm implements RateLimitingAlgorithm {
    int capacity;
    int refillRate;
    int refillAmount;
    
    @Override
    public boolean isAllowed(Bucket bucket) {
        // Business logic to check if the request is allowed
        synchronized (bucket) {
            refillBucket(bucket);
            if (bucket.tokens < 1) {
                return false;
            }
            bucket.tokens--;
            return true;
        }
    }

    public void refillBucket(Bucket bucket) {
        // Business logic to refill the bucket
        long currentTime = System.currentTimeMillis();
        long timeSinceLastRefill = currentTime - bucket.lastRefillTime;
        int tokensToAdd = (int) (timeSinceLastRefill / 1000) * refillRate;
        bucket.lastRefillTime = System.currentTimeMillis();
        bucket.tokens = Math.min(bucket.tokens + tokensToAdd, capacity);
    }
}

class LeakyBucketAlgorithm implements RateLimitingAlgorithm {
    @Override
    public boolean isAllowed(Bucket bucket) {
        // Business logic to check if the request is allowed
        return true;
    }
}

public class RateLimiter {
Map<String, Bucket> buckets;
    RateLimitingAlgorithm algorithm;
    public RateLimiter(RateLimitingAlgorithm algorithm) {
        this.algorithm = algorithm;
        this.buckets = new ConcurrentHashMap<>();
    }
    public boolean isAllowed(String userId, String apiEndpoint) {
        String key = userId + ":" + apiEndpoint;
        return algorithm.isAllowed(buckets.computeIfAbsent(key, k -> new Bucket()));
    }
}


class main {
    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(
            new TokenBucketAlgorithm(
                capacity:10, 
                refillRate:1, 
                refillAmount:1
            )
        );
        System.out.println(rateLimiter.isAllowed("user1", "api1"));
    }
}
