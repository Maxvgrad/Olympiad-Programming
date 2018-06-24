package org.olymp;

import java.io.File;

public class Context {
    private File inputFile;
    private File outputFile;
    private Solvable task;

    public File getInputFile() {
        return inputFile;
    }

    public File getOutputFile() {
        return outputFile;
    }

    public Solvable getTask() {
        return task;
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    public void setTask(Solvable task) {
        this.task = task;
    }
}
