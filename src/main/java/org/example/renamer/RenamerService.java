package org.example.renamer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RenamerService {

    private final FileLoader loader;

    public RenamerService() {
        this.loader = new FileLoader();
    }

    public void process(String path) {
        List<File> files = new ArrayList<>();
        try {
            files = loader.loadFiles(path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        files.forEach(file -> {
            String initialName = file.getName();
            String cleanName = sanitizePath(initialName);
            if (!cleanName.equals(initialName)) {
                String newPath = path + System.getProperty("file.separator") + cleanName;
                System.out.println("New file name: " + newPath);

                file.renameTo(new File(newPath));
            }
        });
    }

    private String sanitizePath(String path) {
        return path.replaceAll("_", " ")
                .replaceAll("\\((.*?)\\)", "")
                .replaceAll("[0-9]", "")
                .replaceAll("Various Artists - |Various Artists", "")
                .trim()
                .replaceAll(" .mp|.mp", ".mp3");
    }
}
