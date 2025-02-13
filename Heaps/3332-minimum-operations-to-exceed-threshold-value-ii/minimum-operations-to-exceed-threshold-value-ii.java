class Solution {
    public int minOperations(int[] nums, int k) {
        // Create a priority queue to store the numbers in ascending order
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int num : nums) 
            pq.offer((long)num);
        int op = 0;
        // Continue processing while there are at least two elements in the queue
        while(pq.size() >= 2) {
            // Poll the smallest element from the queue
            long x = pq.poll();
            if(x >= k) break;            
            long y = pq.poll();  // Poll the next smallest element from the queue
            
            // Calculate the new value to be added back to the queue
            // The new value is the sum of the smaller element doubled and the larger element
            long res = Math.min(x, y) * 2 + Math.max(x, y);
            pq.offer(res);  // Offer the new value back into the priority queue
            op++;
        }
        return op;   // Return the total number of operations performed
    }
}
