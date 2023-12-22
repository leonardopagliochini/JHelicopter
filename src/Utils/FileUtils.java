package Utils;

import java.io.*;

public class FileUtils {
    public static String[][] readSequences(String fileName)
    {
        String[][] seq = new String[5][2];
        try
        {
            BufferedReader in = new BufferedReader (new FileReader(fileName));
            String line = in.readLine ();
            int i = 0;
            for(int x = 0 ; x < 5 ; x++)
            {
                String[] s = line.split(";");
                for (int j = 0 ; j < 2 ;j++) {
                    seq[x][j] = s[j];
                }
                line = in.readLine();
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return seq;
    }

    public static void writeFile(String fileName, String txt)
    {
        try {
            PrintWriter out = new PrintWriter (new FileWriter(fileName));
            out.println(txt);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}