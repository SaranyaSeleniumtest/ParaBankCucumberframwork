package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    static Properties properties;
    public static String getproperty(String value){
        properties=new Properties();
        FileInputStream fis=null;
        try {

            fis=new FileInputStream("src\\test\\resources\\config.Properties");
            try {
                properties.load(fis);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(value);

    }

}
