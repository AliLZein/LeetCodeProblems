class Solution {
    public boolean isPowerOfFour(int n) 
    {
        if(n == 1){return true;}
        if(n % 4 != 0){return false;}
        return recursion(n , 0);
    }

    public boolean recursion(int n , int i)
    {
        if(Math.pow(4 , i) > n){return false;}
        if(Math.pow(4 , i) == n){return true;}
        else{return recursion(n , i + 1);}
    }
}