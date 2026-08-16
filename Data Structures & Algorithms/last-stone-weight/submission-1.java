class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> mx = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            mx.offer(stone);
        }

        while(mx.size() > 1){
            int x = mx.poll();
            int y = mx.poll();

            if(x!=y){
                mx.offer(x-y);
            }

            
        }
        return mx.isEmpty()?0:mx.peek();
    }
}
