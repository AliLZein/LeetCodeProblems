class Solution 
{
    public int[] sortArray(int[] nums) 
    {
        int[] temp = new int[nums.length]; 
        merge(nums , temp , 0 , nums.length - 1);
        return nums;        
    }

    public void merge(int[] list , int[] temp , int left , int right)
    {
        if(left >= right) return;

        int mid = left + (right - left) / 2;
        merge(list , temp , left , mid);
        merge(list , temp , mid + 1 , right);
        mergesort(list , temp , left , mid , right);
    }

    public void mergesort(int[] list , int[] temp , int left , int mid , int right)
    {
        for(int i = left ; i <= right ; i++)
        {
            temp[i] = list[i];
        }

        int i = left;
        int k = left;
        int j = mid + 1;

        while(i <= mid && j <= right)
        {
            if(temp[i] <= temp[j])
            {
                list[k++] = temp[i++];
            }
            else
            {
                list[k++] = temp[j++];
            }
        }

        while(i <= mid)
        {
            list[k++] = temp[i++];
        }

        while(j <= right)
        {
            list[k++] = temp[j++];
        }
    }
}