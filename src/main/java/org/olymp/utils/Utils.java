package org.olymp.utils;

import org.olymp.ConfigYaml;
import org.olymp.Context;
import org.olymp.Solvable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private final static Logger LOGGER = LoggerFactory.getLogger(Utils.class);
    private final static String TASK_NAME = "Task";
    private final static String YAML_CONFIG = "config.yaml";
    private final static String PREFIX = "task";
    private final static String REGEXP_ONE = "task\\d+";
    private final static String REGEX_TWO = "task\\d{4}";
    private final static String REGEX_THREE = "\\d{4}";


    public static Context createContext(String taskPackage, Class<Context> clazz) {
        var conf = load(ConfigYaml.class);
        if  (conf.getTask() == null)
            conf.setTask(taskPackage);
        return createContext(conf);
    }

    private static Context createContext(ConfigYaml c) {
        Context result = new Context();
        var iDir = composeDirName(c.getResultsDir(), c.getTask(), c.getInputName());
        var oDir = composeDirName(c.getResultsDir(), c.getTask(), c.getOutputName());
        var classFullName = composePackageName(Solvable.class.getPackageName(), c.getTask(), TASK_NAME);
        LOGGER.trace("Input file dir: {}\nOutput file dir: {}\nTask class full Name: {}", iDir, oDir, classFullName);
        result.setInputFile(new File(iDir));
        result.setOutputFile(new File(oDir));
        try {
            Solvable t = (Solvable) Class.forName(classFullName).getConstructor().newInstance();
            result.setTask(t);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    public static String composePackageName(String... pkgs) {
        return composeHierarchy(".", pkgs);
    }

    public static String composeDirName(String... folders) {
        return "/" + composeHierarchy("/", folders);
    }

    private static String composeHierarchy(String delimiter, String... elements) {
        String result = "";
        for (String p : elements)
            result += addDelimeters(p, delimiter);
        return result.substring(0, result.length() - 1);
    }

    private static String addDelimeters(String str, String delimeter) {
        var starts = str.startsWith(delimeter);
        var ends = str.endsWith(delimeter);
        str = starts ? str.substring(1) : str;
        str = ends ? str : str + delimeter;
        return str;
    }

    private static String validatePackage(String pkg) {
        if (matchRegexp(pkg, REGEXP_ONE)) {
            if (matchRegexp(pkg, REGEX_TWO)) {
                return pkg;
            }
        } else if (matchRegexp(pkg, REGEX_THREE)) {
            return PREFIX + pkg;
        }
        LOGGER.error("Package name '{}' is not correct", pkg);
        throw new IllegalArgumentException();
    }

    /**
     * @return clazz instance or null
     */
    private static <T> T load(Class<T> clazz) {
        T result = null;
        Yaml yaml = new Yaml();
        try (InputStream is = new FileInputStream(getFile(YAML_CONFIG))) {
            result = yaml.loadAs(is, clazz);
        } catch (IOException | NullPointerException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }
    /**
     * @return File from resources directory.
     * @throws NullPointerException if fileName is not found.
     */
    private static File getFile(String fileName) throws NullPointerException {
        Objects.requireNonNull(fileName = Utils.class.getClassLoader().getResource(fileName).getFile());
        return new File(fileName);
    }

    /**
     * @return mathcing string or null
     */
    private static String extractMatch(String context, String regexp) {
        Matcher m = createMathcer(context, regexp);
        return m.find() ? m.group() : null;
    }

    private static boolean matchRegexp(String context, String regexp) {
        Matcher m = createMathcer(context, regexp);
        return m.matches();
    }

    private static Matcher createMathcer(String context, String regexp) {
        Pattern p = Pattern.compile(regexp);
        return p.matcher(context);
    }

    // move to good Utils class
    /**
     * Check array length
     * @return arr if arr.length == len
     * @throws IllegalArgumentException if arr.length != len
     */
    public static <T> T[] checkArrayLength(int len, T... arr) throws IllegalArgumentException {
        if (arr.length != len)
            throw new IllegalArgumentException(
                    String.format("Not correct length '%d'. Length support to be '%d'", arr.length, len));
        return arr;
    }

    /**
     * Return class name, witch invokes this method, used for LOGGER initialization.
     * Don't use it inside this class.
     */
    public static String getClassName() {
        return Thread.currentThread().getStackTrace()[2].getClassName();
    }


}
