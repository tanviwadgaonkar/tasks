import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class exp1 {

    // Read function
    public static String readFile(String inputFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            StringBuilder data = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
            reader.close();
            System.out.println("Read successful!");
            return data.toString();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
            return null;
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
            return null;
        }
    }

    // Write function
    public static void writeFile(String outputFile, String data) {
        if (data != null) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
                writer.write(data);
                writer.close();
                System.out.println("Write successful!");
            } catch (IOException e) {
                System.out.println("Error while writing: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Thread 1: Read file
        executor.submit(() -> {
            String data = readFile(inputFile);
            if (data != null) {
                writeFile(outputFile, data);
            }
        });

        // Thread 2: Additional content writing
        executor.submit(() -> writeFile(outputFile, "Extra Content\n"));

        executor.shutdown();
        System.out.println("All threads executed successfully!");
    }
}
