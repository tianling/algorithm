package isValid;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class IsValid {

    public static void main(String[] args) {
        String s = "((";

        IsValid isValid = new IsValid();
        boolean res = isValid.solution(s);

        System.out.println(res);
    }

    public boolean solution (String s) {
        if (s.length() < 2 || s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (pairs.get(ch) != null) {
                if (stack.size() == 0 || !stack.peek().equals(pairs.get(ch))) {
                    return false;
                }

                stack.pop();

            } else {
                stack.push(ch);
            }

        }

        return stack.isEmpty();
    }
} 

