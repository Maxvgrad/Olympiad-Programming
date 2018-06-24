package org.olymp.task0008;


import org.olymp.Solvable;
import org.olymp.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Scanner;

public class Task implements Solvable {
    private final static Logger LOGGER = LoggerFactory.getLogger(Utils.getClassName());

    @Override
    public String solve(Scanner sc) {
        var a = sc.nextInt();
        var b = sc.nextInt();
        var c = sc.nextInt();
        return a * b == c ? "YES" : "NO";
    }
}
