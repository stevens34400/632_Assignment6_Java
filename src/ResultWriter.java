package src;

// Import necessary classes for file handling
import java.io.*;

// Class responsible for writing results to a file
public class ResultWriter {
    // Path to the file where results will be written
    private final String filePath;

    // Constructor to initialize the file path
    public ResultWriter(String filePath) {
        this.filePath = filePath;
    }

    // Method to write a result to the file in a thread-safe manner
    public synchronized void writeResult(String result) {
        // Try-with-resources to ensure the FileWriter is closed after use
        try (FileWriter writer = new FileWriter(filePath, true)) {
            // Write the result followed by a newline to the file
            writer.write(result + "\n");
        } catch (IOException e) {
            // Print an error message if writing to the file fails
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}