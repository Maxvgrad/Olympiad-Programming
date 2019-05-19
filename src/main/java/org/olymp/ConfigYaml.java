package org.olymp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigYaml {
    private String inputName;
    private String outputName;
    private String resultsDir;
    private String task;
}
