package org.olymp.taskYandex0002;


import org.olymp.Solvable;
import org.olymp.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Task implements Solvable {
    private final static Logger LOGGER = LoggerFactory.getLogger(Utils.getClassName());

    private String left = "(";
    private String right = ")";
    private String pair = left + right;
    private Integer length;
    private Set<String> result = new HashSet<>();

    @Override
    public String solve(Scanner sc) {

        int num = sc.nextInt();

        if (num == 0) {
            return "";
        }

        if (num == 1) {
            return pair;
        }

        length = num * 2;

        solveInternal(pair);

        new TreeSet<>(result).forEach(System.out::println);
        return new TreeSet<>(result).stream().collect(Collectors.joining("\n"));
    }

    private void solveInternal(String parentheses) {

        if (parentheses.length() >= length) {
            result.add(parentheses);
        } else {
            solveInternal(left(parentheses));
            solveInternal(right(parentheses));
            solveInternal(cover(parentheses));
        }

    }

    private String left(String parentheses) {
        return pair + parentheses;
    }

    private String right(String parentheses) {
        return parentheses + pair;
    }

    private String cover(String parentheses) {
        return left + parentheses + right;
    }
}
