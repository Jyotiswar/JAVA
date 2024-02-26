import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    List<String> out = new ArrayList<>();
    StringBuilder curr = new StringBuilder();

    void subSeq(int i, String s) {
        if (i == s.length()) {
            if (curr.length() > 0)
                out.add(curr.toString());
            return;
        }

        curr.append(s.charAt(i));
        subSeq(i + 1, s);
        curr.deleteCharAt(curr.length() - 1);
        subSeq(i + 1, s);
    }

    public List<String> AllPossibleStrings(String s) {
        subSeq(0, s);
        Collections.sort(out);
        return out;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abc"; // Example input string
        List<String> result = solution.AllPossibleStrings(s);
        for (String str : result) {
            System.out.println(str);
        }
    }
}
