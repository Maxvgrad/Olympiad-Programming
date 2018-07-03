package org.olymp.task0014;


import org.olymp.Solvable;
import org.olymp.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Task implements Solvable {
    private final static Logger LOGGER = LoggerFactory.getLogger(Utils.getClassName());

    @Override
    public String solve(Scanner sc) {
        return lcm(sc.nextInt(), sc.nextInt()) + "";
    }

    /**
     * Euclidean Algorithm
     * */
    private static int euclidGcd(int a, int b) {
        if (b == 0 || a == 0)
            return max(a, b);
        return euclidGcd(min(a, b), max(a, b) % min(a, b));
    }

    /**
     * Least Common Multiple
     */
    public static int lcm(int a, int b) {
        return a * b / euclidGcd(a, b);
    }
}
