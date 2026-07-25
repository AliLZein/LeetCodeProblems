class Solution 
{
    public boolean mergeTriplets(int[][] triplets, int[] target) 
    {
        boolean hasX = false;
        boolean hasY = false;
        boolean hasZ = false;

        int x = target[0];
        int y = target[1];
        int z = target[2];

        for (int[] triplet : triplets) 
        {
            int a = triplet[0];
            int b = triplet[1];
            int c = triplet[2];

            if (a > x || b > y || c > z) 
            {
                continue;
            }

            if (a == x) hasX = true;
            if (b == y) hasY = true;
            if (c == z) hasZ = true;

            if (hasX && hasY && hasZ) 
            {
                return true;
            }
        }

        return hasX && hasY && hasZ;
    }
}