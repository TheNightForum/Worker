package com.tnf.worker.handlers;

/**
 * Created by brayden on 6/3/17.
 */
import java.io.File;

public class Data {

    public static String OPERATING_SYSTEM = System.getProperty("os.name").toLowerCase();
    public static String BaseUrl = "https://thenightforum.github.io/WorkerPackages/";
    public static String location = "";
    public static String locationConfig = "";
    public static String locationToInstall = "";
    static{
        if (OPERATING_SYSTEM.indexOf("win") >= 0) {
            Logger.printLine("User is on WINDOWS.");
            location = System.getenv("APPDATA") + "\\Worker\\";
            locationConfig = location + "config\\";
            locationToInstall = location + "install\\";
        } else if (OPERATING_SYSTEM.indexOf("mac") >= 0) {
            Logger.printLine("User is on MAC.");
            location = System.getProperty( "user.home" ) + "/Worker/";
            locationConfig = location + "config/";
            locationToInstall = location + "install/";
        } else if (OPERATING_SYSTEM.indexOf("nix") >= 0 || OPERATING_SYSTEM.indexOf("nux") >= 0 || OPERATING_SYSTEM.indexOf("aix") > 0) {
            Logger.printLine("User is on LINUX.");
            location = System.getProperty( "user.home" ) + "/Worker/";
            locationConfig = location + "config/";
            locationToInstall = location + "install/";
        } else if (OPERATING_SYSTEM.indexOf("sunos") >= 0) {
            Logger.printLine("Solaris detected.", Logger.WARNING);
            Logger.printLine("Will use LINUX configs.");
            location = System.getProperty( "user.home" ) + "/Worker/";
            locationConfig = location + "config/";
            locationToInstall = location + "install/";
        } else {
            Logger.printLine("Dont know what OS the system is.", Logger.WARNING);
            Logger.printLine("Will pretend it is LINUX.");
            location = System.getProperty( "user.home" ) + "/Worker/";
            locationConfig = location + "config/";
            locationToInstall = location + "install/";
        }
        File file = new File(location);
        file.mkdirs();
        file = new File(locationConfig);
        file.mkdirs();
        file = new File(locationToInstall);
        file.mkdirs();
        Logger.printDebug("Worker root directory: " + location);
        Logger.printLine("Worker configs directory: " + locationConfig);
        Logger.printLine("Worker install directory: " + locationToInstall);
    }

}