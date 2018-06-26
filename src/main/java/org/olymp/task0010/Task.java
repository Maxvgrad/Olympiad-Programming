package org.olymp.task0010;


import org.olymp.Solvable;
import org.olymp.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static java.lang.Math.*;

public class Task implements Solvable {
    private final static Logger LOGGER = LoggerFactory.getLogger(Utils.getClassName());


    /**
     * Solve cubic equation
     */
    @Override
    public String solve(Scanner sc) {
        var result = new StringBuilder();
        var a = sc.nextInt();
        var b = sc.nextInt();
        var c = sc.nextInt();
        var d = sc.nextInt();

        for (int i = -100; i < 101; i++) {
            if ((a * pow(i, 3) + b * pow(i, 2) + c * i + d )== 0) {
                result.append(i).append(" ");
            }
        }
//        var q = (pow(a, 2) - 3 * b) / 9;
//        var r = (2 * pow(a, 3) - 9 * a * b + 27 * c) / 54;
//
//        if (pow(r, 2) > pow(q, 3)) {
//            var t = acos(r / sqrt(pow(q, 3))) / 3;
//            var x1 = -2 * sqrt(q) * cos(t) - a / 3;
//            var x2 = -2 * sqrt(q) * cos(t + 2 * PI / 3) - a / 3;
//            var x3 = -2 * sqrt(q) * cos(t - 2 * PI / 3) - a / 3;
//            result.append(x1).append(" ").append(x2).append(" ").append(x3);
//        } else {
//            var x1 = (a + b) - a / 3;
//            if (a == b) {
//                var x1 = -a - a / 3;
//            }
//            result.append(x1);//.append(" ").append(x2).append(" ").append(x3);
//        }
        LOGGER.info("Result: {}", result.toString());
        return result.toString().trim();
    }
}
