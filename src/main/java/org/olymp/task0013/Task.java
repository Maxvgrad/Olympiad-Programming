package org.olymp.task0013;


import org.olymp.Solvable;
import org.olymp.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task implements Solvable {
    private final static Logger LOGGER = LoggerFactory.getLogger(Utils.getClassName());

    public String solve(Scanner sc) {
        var a = sc.nextInt();
        var b = sc.nextInt();
        List<Integer> aL = new ArrayList<>();
        List<Integer> bL = new ArrayList<>();

        var bull = 0;
        var cow = 0;
        while (b != 0 && a != 0) {
            if (b % 10 == a % 10) {
                bull++;
            } else {
                aL.add(a % 10);
                bL.add(b % 10);
            }
            a /= 10;
            b /= 10;
        }

        for(Integer i : bL) {
            if (aL.contains(i))
                cow++;
        }
        LOGGER.info("{} {}", bull, cow);
        return String.format("%d %d", bull, cow);
    }
}
