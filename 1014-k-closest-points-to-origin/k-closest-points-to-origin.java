class Solution {
    public int distance(int[] point){
        int dis = (point[0]*point[0]) + (point[1]*point[1]);
        return dis;
    }
    public int[][] kClosest(int[][] points, int k) {
        if(k==points.length){
            return points;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][] result = new int[k][2];
        HashMap<Integer,List<int[]>> map = new HashMap<>();
        for(int[] point : points){
            int dis = distance(point);
            map.computeIfAbsent(dis, x -> new ArrayList<>()).add(point);
            pq.add(dis);
        }
        
        int count=0;
        while(count!=k){
           int dist = pq.poll();
           List<int[]> pts = map.get(dist);
            for (int[] p : pts) {
                if (count < k) {
                    result[count++] = p;
                }
            }
        }
        return result;
    }
}