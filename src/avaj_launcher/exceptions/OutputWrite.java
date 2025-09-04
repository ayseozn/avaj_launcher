package avaj_launcher.exceptions;

import static java.lang.System.exit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWrite {
    
    private static BufferedWriter writer = null;

    public static void init(String fileName) throws IOException
    {
        if (writer != null) {
            throw new IllegalStateException("Output writer is already initialized.");
        }
        writer = new BufferedWriter(new FileWriter(fileName));
    }

    public static void write(String message)
    {
        try
        {
            if (writer == null)
                throw new IllegalStateException("Output writer is not initialized. Call init() first.");
            
            writer.write(message + "\n");
        }
        catch (IOException e) {
            System.out.println("Error writing to output file: " + e.getMessage());
            exit(0);
        }
    }

    public static void close() throws IOException
    {
        if (writer != null)
            writer.close();
    }
}