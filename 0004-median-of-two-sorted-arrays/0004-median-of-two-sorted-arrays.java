import java.util.Arrays;
import java.util.List;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int[] l = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, l, 0, nums1.length);
        System.arraycopy(nums2, 0, l, nums1.length, nums2.length);
        Arrays.sort(l);
        int mid = l.length / 2;
        if(l.length % 2 != 0) {return (double)l[mid];}
        else {return (double)(l[mid] + l[mid - 1]) / 2.0;}
    }
}