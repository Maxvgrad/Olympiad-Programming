package org.olymp.task0009;


import org.olymp.Solvable;
import org.olymp.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static java.lang.Math.*;
import java.util.Scanner;

public class Task implements Solvable {
    private final static Logger LOGGER = LoggerFactory.getLogger(Utils.getClassName());

    @Override
    public String solve(Scanner sc) {
        var len = sc.nextInt();
        var sum = 0;
        var multiply = 1;
        var minI = 0;
        var min = Integer.MAX_VALUE;
        var maxI = len;
        var max = Integer.MIN_VALUE;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            var el = sc.nextInt();
            arr[i] = el;
            if (el > 0) {
                sum += el;
            }
            if (el > max) {
                maxI = i;
                max = el;
            }
            if (el < min) {
                minI = i;
                min = el;
            }
        }
        for (int i = min(minI, maxI)+1; i < max(minI, maxI); i++) {
//            LOGGER.trace("{}: {}*{} = {}", i, multiply, arr[i], multiply * arr[i]);
            multiply *= arr[i];
        }
        return String.format("%d %d", sum, multiply);
    }
}
