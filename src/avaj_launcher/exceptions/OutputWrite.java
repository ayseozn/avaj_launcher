package avaj_launcher.exceptions;

import static java.lang.System.exit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWrite {
    
    private static BufferedWriter writer = null;

    public static void init(String fileName) throws IOException
    {
        writer = new BufferedWriter(new FileWriter(fileName));
    }

    public static void write(String message)
    {
        try
        {
            if (writer == null) // olsa iyi olur aslında ama ne bilim ya boş iş gibi
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
        if (writer != null) // writer initlenmeden önce program bitebilir başka bir yerden exception yer kapanırsa diye
            writer.close();
    }
}


// yazı dosyasını kapatmayı unutma catch ile çıkıp gidersen kalır final ekle yada try ın başında çalıştır. başka yöntem var mı bilmiyorum
