class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time=0;
        PriorityQueue<Integer> pq= new PriorityQueue<>(Comparator.reverseOrder());
        HashMap<Character,Integer> freq = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            if(freq.containsKey(tasks[i]))freq.put(tasks[i],freq.get(tasks[i])+1);
            else{freq.put(tasks[i],1);}
        }
        for(Map.Entry<Character,Integer> entry : freq.entrySet()){
            pq.add(entry.getValue());
        }
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;  
            
            while (cycle > 0 && !pq.isEmpty()) {
                int cur = pq.poll();
                if (cur - 1 > 0) {
                    temp.add(cur - 1); 
                }
                time++;
                cycle--;
            }
            for (int rem : temp) pq.add(rem);
            
            if (!pq.isEmpty()) {
                time += cycle;
            }
        }
        return time;
    }
}