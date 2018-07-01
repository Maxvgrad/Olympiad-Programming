package org.olymp.task0012;


import org.olymp.Solvable;
import org.olymp.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task implements Solvable {
    private final static Logger LOGGER = LoggerFactory.getLogger(Utils.getClassName());

    @Override
    public String solve(Scanner sc) {
        var num = sc.nextInt();
        var count = 0;
        while (sc.hasNext()) {
            if (checkParatrooper(process(sc.nextLine())))
                count++;
        }
        return count + "";
    }

    private Integer[] process(String line) {
        return rotateCoords(readCoordinates(line));
    }

    private Integer[] readCoordinates(String line) {
        return Arrays.stream(checkLen(line.split(" "))).map(Integer::parseInt).toArray(Integer[]::new);
    }

    /**
     * Default len is 10
     * @throws IllegalAccessError if arr.length != len
     */
    private <T> T[] checkLen(T... arr) throws IllegalArgumentException {
        return checkLen(10, arr);
    }
    /**
     * @throws IllegalAccessError if arr.length != len
     */
    private <T> T[] checkLen(int len, T... arr) throws IllegalArgumentException {
        if (arr.length != len)
            throw new IllegalArgumentException(
                    String.format("Not correct length '%d'. Length support to be '%d'", arr.length, len));
        return arr;
    }

    private Integer[] rotateCoords(Integer... coords) {
        checkLen(coords);
        var iter = 0;
        Point paratrooperPoint = new Point(coords[iter++], coords[iter++]);
        Point a = new Point(coords[iter++], coords[iter++]);
        Point b = new Point(coords[iter++], coords[iter++]);
        Point c = new Point(coords[iter++], coords[iter++]);
        Point d = new Point(coords[iter++], coords[iter++]);
        return null;
    }

    private Boolean checkIntersection(Integer[] p) {
        return null;
    }

    private Boolean checkParatrooper(Integer... coordinates) {
        checkLen(coordinates);

        return Boolean.TRUE;
    }

    private Double findSlope(Point a, Point b) {
        return Math.abs(1.0 * (a.getY() - b.getY()) / (a.getX() - b.getX()));
    }

    private class Point {
        final Integer x;
        final Integer y;

        public Point(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public Integer getX() {
            return x;
        }

        public Integer getY() {
            return y;
        }
    }
}
