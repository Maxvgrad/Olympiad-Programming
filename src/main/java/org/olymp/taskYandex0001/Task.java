package org.olymp.taskYandex0001;


import lombok.extern.slf4j.Slf4j;
import org.olymp.Solvable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * Написать функцию, проверяющую правильно расставленные скобки;
 * check("{()}[]") // true
 * check("{[}]") // false
 */
@Slf4j
public class Task implements Solvable {

    private static final Map<Character, Character> parenthesesMap = new HashMap<>();

    static {
        parenthesesMap.put('(', ')');
        parenthesesMap.put('{', '}');
        parenthesesMap.put('[', ']');
    }


    @Override
    public String solve(Scanner sc) {
        String line = sc.nextLine();

        log.info("#solve: line: {}", line);
        boolean result = checkParentheses(line);
        log.info("#solve: result: {}", result);

        return result + "";
    }

    private boolean checkParentheses(String parentheses) {

        if (parentheses == null || parentheses.trim().isEmpty()) {
            throw new IllegalArgumentException("Argument: " + parentheses);
        }

        if (parentheses.length() == 1) {
            return false;
        }

        LinkedList<Character> stack = new LinkedList<>();

        stack.push(parentheses.charAt(0));

        for (int i = 1; i < parentheses.length(); i++) {

            char bracket = parentheses.charAt(i);

            if (isOpen(bracket)) {
                stack.push(bracket);

            } else if (isClose(bracket)) {
                Character fromStack = stack.poll();

                if (fromStack == null || !isMach(fromStack, bracket)) {
                    return false;
                }

            } else {
                throw new IllegalArgumentException("Unsupported char: " + bracket);
            }

        }
        return stack.isEmpty();

    }

    private boolean isOpen(char bracket) {
        return parenthesesMap.containsKey(bracket);
    }

    private boolean isClose(char bracket) {
        return parenthesesMap.containsValue(bracket);
    }

    private boolean isMach(char openBracket, char closeBracket) {
        return parenthesesMap.containsKey(openBracket) && parenthesesMap.get(openBracket) == closeBracket;
    }

}
