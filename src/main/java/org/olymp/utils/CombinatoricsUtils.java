package org.olymp.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.*;
import static java.lang.Math.*;

public class CombinatoricsUtils {

    private CombinatoricsUtils() {}

    public static BigInteger factorial(final long n) {
        return factorial(BigInteger.valueOf(n));
    }

    private static BigInteger factorial(final BigInteger n) {
        var result = ONE;
        for (BigInteger i = ONE; i.compareTo(n) < 0; i=i.add(ONE)) {
            result = result.multiply(i);
        }
        return result;
    }

    /**
     * Number if premutations without repetition
     */
    public static long permutations(long n, long r) {
        return factorial(max(n, r)).divide(factorial(max(n, r) - min(n, r))).longValue();
    }

    /**
     * Combination without repetitions
     */
    public static long combinations(long n, long r) {
        return permutations(n, r) / factorial(min(n, r)).longValue();
    }

    public static <T> List<T>[] combinations(List<T> list) {
        List<List<T>> result = new ArrayList<>();

        return null;
//        return
    }

//    private static <T>

//    private


    /**
     * Greatest Common Divisor
     */
    public static int gcd(int a, int b) {
        return euclidGcd(a, b);
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
