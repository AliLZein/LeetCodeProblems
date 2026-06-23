import java.util.HashSet;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char number = board[r][c];
                
                if (number != '.') {
                    
                    String rowMarker = "row " + r + " has " + number;
                    String colMarker = "col " + c + " has " + number;
                    String boxMarker = "box " + (r / 3) + "-" + (c / 3) + " has " + number;
                    
                    if (!seen.add(rowMarker) || !seen.add(colMarker) || !seen.add(boxMarker)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}