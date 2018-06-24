package org.olymp;

public class ConfigYaml {
    private String inputName;
    private String outputName;
    private String resultsDir;
    private String task;

    public String getInputName() {
        return inputName;
    }

    public String getOutputName() {
        return outputName;
    }

    public String getResultsDir() {
        return resultsDir;
    }

    public String getTask() {
        return task;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public void setOutputName(String outputName) {
        this.outputName = outputName;
    }

    public void setResultsDir(String resultsDir) {
        this.resultsDir = resultsDir;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
