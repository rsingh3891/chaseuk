package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Data From JSON File - This class is used to handle actions for retrieving data from a JSON file
 *
 * @author Raj Singh <I>(21/09/2022)</I>
 */
public class DataFromJSONFile {

    private String path;

    /**
     * Constructor Method - sets the filepath of the filename passed in
     * @param fileName
     */
    public DataFromJSONFile(final String fileName) {
        path = "src/main/resources/" + fileName + ".json";
    }

    /**
     * getJSONFileContents - read all the file contents to a string variable
     * @return String content
     */
    public String getJSONFileContents() {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return content;
    }
}
