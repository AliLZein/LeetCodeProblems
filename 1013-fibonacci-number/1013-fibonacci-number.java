class Solution {
    public int fib(int n) 
    {
        if(n <= 1){return n;}
        int[] l = new int[n + 1];
        l[0] = 0;
        l[1] = 1;
        return fibo(n , l , 2);
    }

    public int fibo(int n , int[] l , int i)
    {
        if(i > n){return l[n];}
        l[i] = l[i - 1] + l[i - 2];
        return fibo(n , l , i + 1);
    }
}