class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for(char task : tasks){
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        for(int count : freq){
            if(count>0){
                pq.offer(count);
            } 
        }

        Queue<int[]> que= new LinkedList<>();
        int time =0;
        while(!pq.isEmpty() || !que.isEmpty() ){
            time++;
            if(!pq.isEmpty()){
                int remaining = pq.poll();
                remaining--;
                if(remaining>0){
                    que.offer(
                        new int[]{remaining,time+n}
                    );
                }
            }

            if(!que.isEmpty() && que.peek()[1] == time){
                int[] task= que.poll();
                pq.offer(task[0]);
            }
        }
        return time;
     }
}
