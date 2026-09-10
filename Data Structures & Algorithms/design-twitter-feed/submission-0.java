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
        // Add tweet as [time, tweetId], then increase time
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // Start feed with user's own tweets
        List<int[]> feed = new ArrayList<>(
            tweetMap.getOrDefault(userId, new ArrayList<>()));

        // Add tweets from all followees
        for (int followeeId : followMap.getOrDefault(userId, new HashSet<>())){
            feed.addAll(tweetMap.getOrDefault(followeeId, new ArrayList<>()));
        }

        // Sort most recent first by timestamp
        feed.sort((a, b) -> b[0] - a[0]);

        // Return at most 10 tweetIds
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.min(10, feed.size()); i++){
            res.add(feed.get(i)[1]);
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        // Ignore following yourself
        if (followerId != followeeId){
            followMap.putIfAbsent(followerId, new HashSet<>());
            followMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        // Remove followee if follower exists
        followMap.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}

//Brute Force: Sorting 
//Time complexity: O(n log n) for each getNewsFeed() and O(1) for other methods
//Space complexity: O(N*m + N*M + n)

//where n = the total number of followeeIds associated with userId
// m = max number of tweets by any user 
// N = total number of userIds
// M = max number of followees for any users

//For brute force, I'd collect all tweets from the user and everyone they follow, sort by timestamp descending, and return the top 10. This works but is inefficient — it's O(N log N) where N is the total number of tweets, even though we only need 10.