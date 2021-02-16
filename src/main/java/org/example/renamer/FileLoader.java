package org.example.renamer;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class FileLoader {

    public List<File> loadFiles(String folderPath) {
        System.out.println("Received folder path: " + folderPath);
        List<File> files = new LinkedList<>();

        File folder = new File(folderPath);
        if (!folder.exists()) {
            throw new IllegalArgumentException("Invalid path received");
        }

        System.out.println(folder.isDirectory());

        for (File temp : folder.listFiles()) {
            System.out.println(temp.getAbsolutePath());
            files.add(temp);
        }

        return files;
    }
}
