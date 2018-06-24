package org.olymp.task0007;


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
        var result = new BigInteger(Integer.MIN_VALUE+"");
        while (sc.hasNext()) {
            var val = new BigInteger(sc.next());
            LOGGER.trace("Value: {}", val);
            if (val.compareTo(result) > 0) {
                result = val;
            }
        }
        LOGGER.trace("Result: {}", result);
        return result.toString();
    }
}
