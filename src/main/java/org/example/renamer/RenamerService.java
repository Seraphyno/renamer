package org.example.renamer;

import java.io.File;
import java.util.List;

public class RenamerService {

    private final FileLoader loader;

    public RenamerService() {
        this.loader = new FileLoader();
    }

    public void rename(String path) {
        List<File> files = loader.loadFiles(path);
    }
}
