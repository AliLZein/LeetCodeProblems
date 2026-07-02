import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) 
    {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        int[][] answer = new int[intervals.length][2];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int last = intervals[0][1];

        int count = 1; 
        answer[0][0] = intervals[0][0];
        answer[0][1] = intervals[0][1];
        
        for(int i = 1 ; i < intervals.length ; i++)
        {
            if(intervals[i][0] <= last)
            {
                last = Math.max(last, intervals[i][1]);
                answer[count - 1][1] = last;
            }
            else
            {
                answer[count][0] = intervals[i][0];
                answer[count][1] = intervals[i][1];
                last = intervals[i][1];
                count += 1;
            }
        }
        
        int[][] realanswer = new int[count][2];
        for(int j = 0 ; j < count ; j++)
        {
            realanswer[j] = answer[j];
        }
        return realanswer;
    }
}