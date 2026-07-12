class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 > len2) return false;
        
        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];
        
        for (int i = 0; i < len1; i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i) - 'a']++;
        }
        
        if (matches(s1Counts, s2Counts)) return true;
        
        for (int i = len1; i < len2; i++) {
            s2Counts[s2.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i - len1) - 'a']--;
            
            if (matches(s1Counts, s2Counts)) return true;
        }
        
        return false;
    }
    
    private boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}