import java.util.HashSet;

public class Solution {
    public String removeDuplicates(String str) {
        HashSet<Character> set = new HashSet<>();
        StringBuilder out = new StringBuilder();
        
        for (char ch : str.toCharArray()) {
            if (!set.contains(ch)) {
                out.append(ch);
                set.add(ch);
            }
        }
        
        return out.toString();
    }
}
