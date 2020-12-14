package com.parasoft.nathantest;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyObject {
    private Path sessionDir;
    protected static final Predicate<Path> PATH_FILTER = path -> {
        String name = path.getFileName().toString();
        return !name.equals("test.json") && name.endsWith(".json");
    };

    // Test created but unable to handle setting input to something different than empty string - advice for user to increase length > 0
    // Need better handling for strings
    public boolean calculate(String input) {
        if (input != null && input.length() > 0) {
            int a = 2;
            a+=2;
            return true;
        }
        return false;
    }
    public boolean checkURL(URL url) {
        return true;
    }

    public long getNumberOfActions() throws IOException {
        try (Stream<Path> paths = Files.walk(sessionDir)) {
            return paths.filter(PATH_FILTER).count();
        }
    }

    public boolean isMyObject(MyObject MyObject) {
        return true;
    }
}
