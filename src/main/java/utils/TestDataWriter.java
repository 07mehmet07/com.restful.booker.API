package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataWriter {
    public static void writeData(Object object,String path){
        ObjectMapper objectMapper = new ObjectMapper();
        FileOutputStream output;
        try {
            output = new FileOutputStream("C:\\Users\\HP\\workspace\\Restful-BookerAPIAutomation\\src\\test\\resources\\test_data\\" + path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            objectMapper.writeValue(output,object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
