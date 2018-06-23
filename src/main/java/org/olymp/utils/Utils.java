package org.olymp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private final static Logger LOGGER = LoggerFactory.getLogger(Utils.class);
    private final static String INPUT = "/input.txt";
    private final static String OUTPUT = "/output.txt";
    private final static String regex = "task\\d+";

    public static File getInputFile(Class clazz) {
        return getFile(clazz, INPUT);
    }

    public static File getOutputFile(Class clazz) {
        return getFile(clazz, OUTPUT);
    }

    private static File getFile(Class clazz, String fileName) {
        var folder = Objects.requireNonNullElse(extractMatch(clazz.getPackageName(), regex), "");
        LOGGER.trace("folder: {}", folder);
        var path = folder + fileName;
        return new File(clazz.getClassLoader().getResource(path).getFile());
    }

    /**
     * @return mathcing string or null
     */
    private static String extractMatch(String context, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(context);
        if (m.find()) {
            return m.group();
        }
        return null;
    }

    public static String getClassName() {
        return Thread.currentThread().getStackTrace()[2].getClassName();
    }


}
