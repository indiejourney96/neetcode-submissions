class Twitter {

    private int time; // increasing timestamp
    private Map<Integer, Set<Integer>> followMap; // user -> followees
    private Map<Integer, List<int[]>> tweetMap; // user -> list of [time, tweetId]

    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        // Create tweet list if user not seen before
        tweetMap.putIfAbsent(userId, new ArrayList<>());

        // Store tweet as [time, tweetId]
        tweetMap.get(userId).add(new int[]{time, tweetId});

        // Decrease time so newer tweets have smaller values
        // This lets us use a min-heap like a max-heap
        time--;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        // Min-heap by time
        // Each heap item = [time, tweetId, userId, indexInTweetList]
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Make sure user follows themself
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        // Add the most recent tweet from each followed user
        for (int followeeId : followMap.get(userId)) {
            if (!tweetMap.containsKey(followeeId)) continue;

            List<int[]> tweets = tweetMap.get(followeeId);
            int lastIndex = tweets.size() - 1;
            int[] tweet = tweets.get(lastIndex);

            heap.offer(new int[]{tweet[0], tweet[1], followeeId, lastIndex - 1});
        }

        // Get up to 10 most recent tweets
        while (!heap.isEmpty() && res.size() < 10) {
            int[] curr = heap.poll();

            int tweetId = curr[1];
            int authorId = curr[2];
            int nextIndex = curr[3];

            res.add(tweetId);

            // Add the next older tweet from the same user
            if (nextIndex >= 0) {
                int[] nextTweet = tweetMap.get(authorId).get(nextIndex);
                heap.offer(new int[]{nextTweet[0], nextTweet[1], authorId, nextIndex - 1});
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        // Optional: do not allow unfollowing yourself
        if (followMap.containsKey(followerId) && followerId != followeeId) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}

//Heap Solution 
// | Method          |           Time | Extra Space |
// | --------------- | -------------: | ----------: |
// | `postTweet()`   |   O(1) average |        O(1) |
// | `follow()`      |   O(1) average |        O(1) |
// | `unfollow()`    |   O(1) average |        O(1) |
// | `getNewsFeed()` | **O(F log F)** |    **O(F)** |


//where F = number of followees for the requested user.

//For brute force, I'd collect all tweets from the user and everyone they follow, sort by timestamp descending, and return the top 10. This works but is inefficient — it's O(N log N) where N is the total number of tweets, even though we only need 10. 
//Since I only need the 10 most recent tweets, I use a min-heap to perform a k-way merge. I initially add the most recent tweet from each followee, then repeatedly take the newest tweet and add that user's next older tweet. Since there are F followees and I only need 10 tweets, the complexity is O(F log F)