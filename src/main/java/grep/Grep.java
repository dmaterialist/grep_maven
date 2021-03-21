package grep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Grep {
    private static boolean regex;
    private static boolean inversion;
    private static boolean ignore;

    public Grep(Boolean regex, Boolean inversion, Boolean ignore) {
        Grep.regex =regex;
        Grep.inversion =inversion;
        Grep.ignore =ignore;
    }

    public static void search(String word, String file) {
        try {
            if (!regex) {
                word = "\\Q" + word + "\\E";
                System.out.println(word);
            }
            if (ignore) {
                word = "(?i)" + word + "(?-i)";
                System.out.println(word);
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((reader.readLine()) != null) {
                String line = reader.readLine();
                if (inversion) {
                    if (!line.matches(".*"+word+".*"))
                        System.out.println(line);
                } else {
                    if (line.matches(".*"+word+".*"))
                        System.out.println(line);
                }
            }
            reader.close();
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}