package org.olymp;

import java.util.*;
import java.io.*;
import org.olymp.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main { //имя класса должно быть Main

    private final static Logger LOGGER = LoggerFactory.getLogger(Utils.getClassName());

    private Context context;

    Main(String task) {
        this.context = Utils.createContext(task, Context.class);
    }

    public static void main(String[] args) throws IOException{

        if (args.length != 1) {
            LOGGER.warn("usage: java -jar Olympiad-Programming.jar task0001");
            return;
        }
        LOGGER.info("Start task: {}", args[0]);

        new Main(args[0]).run();

    }


    void run() throws IOException{

        try (Scanner sc = new Scanner(context.getInputFile());
             PrintWriter pw = new PrintWriter(context.getOutputFile())) {

            pw.print(context.getTask().solve(sc));

        }
    }
}
