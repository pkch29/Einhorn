package reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A generic file reader.
 * Expects the text files to be in Resources/ folder. Returns the file content as List of String.
 */
public class Reader {

    /**
     * Reads a text file and returns its content as List of String.
     * The text file needs to be in the Resources/ folder.
     * @param filename name of the text file to read
     * @return the content of the text file as List of String.
     * @throws IOException If anything goes wrong while opening/reading the file.
     */
    public static List<String> read(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(Reader.class.getResourceAsStream("/Resources/"+filename)));
        List<String> valueList = new ArrayList<>();
        String line;
        String[] values;
        while((line = reader.readLine()) != null){
            values = line.split(":");
            if(values.length > 1){
                valueList.add(values[1].trim());
            }
        }
        reader.close();
        return valueList;
    }

}
