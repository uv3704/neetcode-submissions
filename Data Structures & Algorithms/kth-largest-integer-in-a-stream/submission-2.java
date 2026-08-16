class KthLargest {

    private int p;
    private PriorityQueue<Integer> pq ;

    public KthLargest(int k, int[] nums) {
        p = k;
        pq = new PriorityQueue<>();

        for(int num : nums){
            add(num);
        }
    }
    
    public int add(int val) {
        pq.offer(val);

        if(pq.size() > p){
            pq.poll();
        }
        return pq.peek();
    }
}
