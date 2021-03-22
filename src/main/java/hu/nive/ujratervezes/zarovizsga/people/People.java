package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {

    public int getNumberOfMales(String path) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            return processLines(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    private int processLines(BufferedReader reader) throws IOException {
        int result = 0;
        reader.readLine();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] splitLine = line.split(",");
            if (splitLine[4].equals("Male")) {
                result++;
            }
        }
        return result;
    }
}
