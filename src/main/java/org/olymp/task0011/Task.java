package org.olymp.task0011;


import org.olymp.Solvable;
import org.olymp.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Solvable {
    private final static Logger LOGGER = LoggerFactory.getLogger(Utils.getClassName());
    static long count = 0;
    static final BigInteger ONE = new BigInteger("1");
    static final BigInteger ZERO = new BigInteger("0");
    private static int step;

    /**
     * В единственной строке входного файла INPUT.TXT записаны два натуральных числа K и N (1 ≤ K ≤ N ≤ 300).
     * К - максимальное количество ступенек, которое может преодолеть заяц одним прыжком,
     * N – общее число ступенек лестницы.
     */
    @Override
    public String solve(Scanner sc) {
        int step = sc.nextInt();
        String n = "";
        while (sc.hasNext()) {
            n += sc.next();
        }
        var t = System.nanoTime();
        BigInteger[] arr = new BigInteger[Integer.valueOf(n)+1];
        arr[0] = new BigInteger("1");
        for (int i = 1; i <= Integer.valueOf(n); i++) {
            BigInteger sum = new BigInteger("0");
            for (int j = 1; j <= step; j++) {
                if (i - j >= 0) {
                    sum = sum.add(arr[i - j]);
                }
                arr[i] = sum;
            }
        }
        LOGGER.info("Sum: {}", arr[Integer.valueOf(n)]);
        LOGGER.info("Time spent: {}", System.nanoTime() - t);
        return arr[Integer.valueOf(n)].toString();
    }

    private void createGraph(long n)  {
        if (n == 0) {
            count++;
//            count = count.add(ONE);
            LOGGER.info("Count: {}", count);
        }
        for (int i = step; i > 0; i--) {
            if (n - i >= 0) {
                createGraph(n - i);
            }
        }
    }
}
