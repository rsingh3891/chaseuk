package utilities;

import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * DataFromPropertiesFile - Retrieves the data from a given properties file
 *
 * @author Raj Singh <I>(22/09/2022)</I>
 */
public class DataFromPropertiesFile {

    private Properties properties;
    private InputStream inputStream;

    /**
     * Default Constructor - reads the properties file for a given filename
     * @param fileName
     */
    public DataFromPropertiesFile(final String fileName) {
        properties = new Properties();
        try {
            inputStream = new FileInputStream("src/main/resources/" + fileName + ".properties");
            properties.load(inputStream);
        } catch(final FileNotFoundException e) {
            Assert.fail();
        } catch(final IOException e) {
            Assert.fail();
        }
    }

    /**
     * getPropertyValue - returns the value of the key provided from the properties file
     * @param key
     * @return String value
     */
    public String getPropertyValue(final String key) {
        final String value = properties.getProperty(key);
        if(value.equals(null)) {
            Assert.fail();
        }
        return value;
    }
}
