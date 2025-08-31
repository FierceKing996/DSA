class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        if(nums.length<=k){
            for(int i =0;i<nums.length;i++){
                pq.add(nums[i]);
            }
        }
        if(nums.length>k){
            for(int i =0;i<k;i++){
                pq.add(nums[i]);
            }
            for(int i = k;i<nums.length;i++){
                if(nums[i]>pq.peek()){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */