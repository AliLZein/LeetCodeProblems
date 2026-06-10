class Solution {
    public String intToRoman(int n) 
    {
        String ss = "";
        StringBuilder s = new StringBuilder();
        
        ss = helperToTi7weel(n, 1000, "M", "", 0, 0);
        s.append(ss);
        n %= 1000;

        ss = helperToTi7weel(n, 500, "D", "CM", 900, 900);
        s.append(ss);
        n = updateN(n, 500, 900);
        
        ss = helperToTi7weel(n, 100, "C", "CD", 400, 400);
        s.append(ss);
        n = updateN(n, 100, 400);
        
        ss = helperToTi7weel(n, 50, "L", "XC", 90, 90);
        s.append(ss);
        n = updateN(n, 50, 90);
        
        ss = helperToTi7weel(n, 10, "X", "XL", 40, 40);
        s.append(ss);
        n = updateN(n, 10, 40);
        
        ss = helperToTi7weel(n, 5, "V", "IX", 9, 9);
        s.append(ss);
        n = updateN(n, 5, 9);
        
        ss = helperToTi7weel(n, 1, "I", "IV", 4, 4);
        s.append(ss);
        n = updateN(n, 1, 4);
        
        return s.toString();
    }

        public static String helperToTi7weel(int n, int num, String ss, String subStr, int subValue, int target) {
        if (n >= target && target != 0) {
            return subStr;
        }
        
        StringBuilder s = new StringBuilder();
        int temp = n / num;
        while (temp > 0) {
            s.append(ss); 
            temp -= 1;
        }
        return s.toString();
    }
    
    public int updateN(int n, int num, int target) {
        if (n >= target && target != 0) {
            return n - target; 
        }
        return n % num;
    }
}