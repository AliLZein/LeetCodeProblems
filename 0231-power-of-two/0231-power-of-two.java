class Solution {
    public boolean isPowerOfTwo(int n) 
    {
        if(n == 1){return true;}
        if(n % 2 != 0){return false;}
        return recursion(n , 0);
    }

    public boolean recursion(int n , int i)
    {
        if(Math.pow(2 , i) > n){return false;}
        if(Math.pow(2 , i) == n){return true;}
        else{return recursion(n , i + 1);}
    }
}