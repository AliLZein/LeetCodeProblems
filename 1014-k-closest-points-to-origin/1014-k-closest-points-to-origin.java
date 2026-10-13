import java.util.Random;

class Solution 
{
    private final Random rand = new Random();

    public int[][] kClosest(int[][] points, int k) {
        int left = 0;
        int right = points.length - 1;

        while (left < right) 
        {
            int pivotIndex = left + rand.nextInt(right - left + 1);
            int newPivot = partition(points, left, right, pivotIndex);

            if (newPivot == k) {
                break;
            } else if (newPivot < k) {
                left = newPivot + 1;
            } else {
                right = newPivot - 1;
            }
        }

        int[][] result = new int[k][2];
        System.arraycopy(points, 0, result, 0, k);
        return result;
    }

    private int partition(int[][] points, int left, int right, int pivotIndex) 
    {
        int pivotDist = dist(points[pivotIndex]);
        swap(points, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (dist(points[i]) < pivotDist) {
                swap(points, storeIndex, i);
                storeIndex++;
            }
        }

        swap(points, storeIndex, right);
        return storeIndex;
    }

    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}