class Solution {
    public boolean isInterleave(String s1, String s2, String s3) 
    {
        if(s1 == null || s2 == null || s3 == null){return false;}
        if(s1.length() + s2.length() != s3.length()){return false;}
        Boolean[][] list = new Boolean[s1.length() + 1][s2.length() + 1];
        return helper(s1 , s2 , s3 , list , 0 , 0);
    }

    public boolean helper(String s1 , String s2 , String s3 , Boolean[][] list , int i , int j)
    {
        if(i + j == s3.length()){return true;}

        if(list[i][j] != null){return list[i][j];}

        boolean matchs1 = false;
        boolean matchs2 = false;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(i + j))
        {
            matchs1 = helper(s1 , s2 , s3 , list , i + 1 , j);
        }

        if(j < s2.length() && s2.charAt(j) == s3.charAt(i + j))
        {
            matchs2 = helper(s1 , s2 , s3 , list , i , j + 1);
        }

        list[i][j] = matchs1 || matchs2;

        return list[i][j];
    }
}