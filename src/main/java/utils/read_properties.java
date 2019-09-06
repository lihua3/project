package utils;

import java.io.*;
import java.util.Properties;

public class read_properties {
    public static void main(String[] args) throws IOException {



        Properties properties = new Properties();
        BufferedReader br = new BufferedReader(new FileReader("config.properties"));
        //BufferedReader br1 = new BufferedReader(new FileReader("D:\\IdeaProjects\\maven_java1\\src\\main\\java\\utils\\config.properties"));
        properties.load(br);

        String name = properties.getProperty("version");
        System.out.println(name);

    }
}
