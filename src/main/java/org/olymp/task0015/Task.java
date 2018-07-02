package org.olymp.task0015;


import org.olymp.Solvable;
import org.olymp.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Task implements Solvable {
    private final static Logger LOGGER = LoggerFactory.getLogger(Utils.getClassName());

    @Override
    public String solve(Scanner sc) {
        var count = 0;
        var n = sc.nextInt();
        sc.nextLine();
        for (var i = 0; i < n; i++) {
            var arr = sc.nextLine().split(" ");
            for (var j = i; j < n; j++) {
                if (Integer.parseInt(arr[j]) == 1)
                    count++;
            }
        }
//        LOGGER.info("count: {}", count);
        return count + "";
    }
}
