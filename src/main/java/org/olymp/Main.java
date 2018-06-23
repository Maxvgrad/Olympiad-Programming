package org.olymp;

import java.util.*;
import java.io.*;
import org.olymp.task0007.Task;
import org.olymp.utils.Utils;

public class Main{ //имя класса должно быть Main
    private final File inputFile;
    private final File outputFile;
    private final Task task;
    PrintWriter pw;
    Scanner sc;

    public Main() {
        task = new Task();
        inputFile = Utils.getInputFile(Task.class);
        outputFile = Utils.getOutputFile(Task.class);
    }

    public static void main(String[] argv) throws IOException{
        new Main().run();
    }
    public void run() throws IOException{
        sc = new Scanner(inputFile);
        pw = new PrintWriter(outputFile);
        pw.print(task.solve(sc));
        pw.print(1);
        pw.flush();
        pw.close();
    }
}
