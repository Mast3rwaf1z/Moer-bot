package bot1;

import java.io.*;

/**
 * log
 */
public class log {
    static public String readFile() throws IOException {
        FileReader input = new FileReader("mørlog.txt");
        System.out.println("data read");
        BufferedReader reader = new BufferedReader(input);

        String c = reader.readLine();
        reader.close();
        return (c);
    }

    static public void writeFile(String number) throws IOException {
        FileWriter output = new FileWriter("mørlog.txt");
        BufferedWriter writer = new BufferedWriter(output);
        System.out.println("data written");
        writer.write(number);
        writer.close();
    }
}