
package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simone on 10.09.2016.
 */
public class Reader {

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
