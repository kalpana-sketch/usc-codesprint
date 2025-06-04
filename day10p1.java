import java.util.*;

public class day10p1 {
    static Map<Character, String> keypadMap = new HashMap<>();

    static {
        keypadMap.put('2', "abc");
        keypadMap.put('3', "def");
        keypadMap.put('4', "ghi");
        keypadMap.put('5', "jkl");
        keypadMap.put('6', "mno");
        keypadMap.put('7', "pqrs");
        keypadMap.put('8', "tuv");
        keypadMap.put('9', "wxyz");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("digits : ");
        String digits = sc.nextLine().trim();
        sc.close();

        List<String> combinations = letterCombinations(digits);
        System.out.println(combinations);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String possibleLetters = keypadMap.get(digits.charAt(index));
        for (char c : possibleLetters.toCharArray()) {
            current.append(c);
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);  // backtrack
        }
    }   
}


