package dattv.example;

import java.io.*;
import java.util.logging.Logger;

public class PathTraversalExample {
    public static void main(String[] args) throws IOException {
        String userInput = "../secret.txt";
        File file = new File(userInput);
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            Logger.getLogger("Reading file: " + file.getPath());
            reader.close();
        }
    }
}
