import java.util.Arrays;
import java.util.List;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int j = 0;
        int[] l = new int[nums1.length + nums2.length];
        for(int i = 0 ; i < nums1.length ; i++) 
        {
            l[i] = nums1[i];
        }

        for(int i = 0 ; i < nums2.length ; i++) 
        {
            l[nums1.length + i] = nums2[i];
        }
        Arrays.sort(l);
        int mid = l.length / 2;
        if(l.length % 2 != 0) {return (double)l[mid];}
        else {return (double)(l[mid] + l[mid - 1]) / 2.0;}
    }
}