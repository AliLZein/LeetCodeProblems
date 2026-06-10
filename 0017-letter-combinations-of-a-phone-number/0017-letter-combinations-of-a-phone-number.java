class Solution {
    public List<String> letterCombinations(String digits) 
    {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result; 
        }

        HashMap<String, String> hm = new HashMap<>();
        hm.put("2", "abc");  hm.put("3", "def");  hm.put("4", "ghi");
        hm.put("5", "jkl");  hm.put("6", "mno");  hm.put("7", "pqrs");
        hm.put("8", "tuv");  hm.put("9", "wxyz");

        result.add("");

        for (int i = 0; i < digits.length(); i++) {
            String digit = String.valueOf(digits.charAt(i));
            String letters = hm.get(digit);

            List<String> temp = new ArrayList<>();
            for (String savedString : result) {
                for (int j = 0; j < letters.length(); j++) {
                    temp.add(savedString + letters.charAt(j));
                }
            }
            result = temp;
        }

        return result;
    }
}