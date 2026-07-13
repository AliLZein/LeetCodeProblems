import java.util.HashMap;
import java.util.Map;

class DetectSquares {
    private Map<Integer, Map<Integer, Integer>> pointCounts;

    public DetectSquares() {
        pointCounts = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        
        pointCounts.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yCounts = pointCounts.get(x);
        
        yCounts.put(y, yCounts.getOrDefault(y, 0) + 1);
    }
    
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int totalSquares = 0;
        
        if (!pointCounts.containsKey(x1)) 
        {
        }
        
        for (int x2 : pointCounts.keySet()) {
            int sideLength = Math.abs(x1 - x2);

            if (sideLength == 0) continue;
            
            Map<Integer, Integer> yCountsForX2 = pointCounts.get(x2);
            
            int[] potentialY2s = {y1 + sideLength, y1 - sideLength};
            
            for (int y2 : potentialY2s) {
                if (yCountsForX2.containsKey(y2)) {
                    int diagCount = yCountsForX2.get(y2);
                    
                    int c3Count = pointCounts.containsKey(x1) ? pointCounts.get(x1).getOrDefault(y2, 0) : 0;
                    
                    int c4Count = yCountsForX2.getOrDefault(y1, 0);
                    
                    totalSquares += diagCount * c3Count * c4Count;
                }
            }
        }
        
        return totalSquares;
    }
}