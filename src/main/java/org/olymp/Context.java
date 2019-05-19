package org.olymp;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class Context {
    private File inputFile;
    private File outputFile;
    private Solvable task;
}
