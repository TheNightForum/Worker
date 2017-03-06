package com.tnf.worker.handlers;

import java.io.*;
import java.util.Properties;

/**
 * Created by brayden on 6/3/17.
 */
public class Handler {
    public static String Result = "";
    public static final String Installed = "_Installed";


    public static String readConfig(String toRead){
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream(Data.locationConfig + "config.properties");

            // load a properties file
            prop.load(input);
            if(prop.getProperty(toRead) != null){
                Result = prop.getProperty(toRead);
            }else{
                Result = "NUL";
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return toRead;
    }


    public static void writeConfig(String option, String newSetting ) {
        OutputStream out = null;
        try {
            Properties props = new Properties();
            File f = new File(Data.locationConfig + "config.properties");

            props.load(new FileReader(f));
            props.setProperty(option, newSetting);

            out = new FileOutputStream(f);
            props.store(out, "Please do not manually edit this file.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.printLine("IOException: Could not close config.properties output stream", Logger.ERROR);
                }
            }
        }
    }
}
