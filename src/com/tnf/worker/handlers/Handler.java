package com.tnf.worker.handlers;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.Properties;

/**
 * Created by brayden on 6/3/17.
 */
public class Handler {
    public static String Result = "";
    public static final String Installed = "_Installed";

    public static final String P_Version = "version";
    public static final String P_Name = "name";
    public static final String P_DownloadURL = "downloadURL";
    public static final String P_IsZip = "isZip";
    public static final String P_ZipDir = "zipDir";
    public static final String P_NeedsLibs = "needsLibs";
    public static final String P_Creator = "creator";
    public static final String P_ShellScript = "isShellScript";
    public static final String P_ShellDir = "shellDir";
    public static final String P_ZipURL = "zipURL";

    public static String readPackage(String string, String toRead){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(Data.locationToInstall + string + "/config.properties");

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

    public static void Download(File f, String string, String file){
        try(
                ReadableByteChannel in= Channels.newChannel(

                        new URL(Data.BaseUrl + "packages/" + string + "/" + file).openStream());
                FileChannel out=new FileOutputStream(f + "/" + file).getChannel() ) {
            out.transferFrom(in, 0, Long.MAX_VALUE);
        }
        catch(IOException ex){
            Logger.printLine("Could not download Launcher.", Logger.ERROR);
        }

    }
}
