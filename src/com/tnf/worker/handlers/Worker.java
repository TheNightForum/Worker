package com.tnf.worker.handlers;

import java.io.File;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by brayden on 6/3/17.
 */
public class Worker {
    private static Boolean isInternet;
    private static Boolean isInstalled;


    public void main(String string){
        checkInternet();
        Handler.readConfig(String.valueOf(string + Handler.Installed));
        if (!Handler.Result.equals("NUL")) isInstalled = Boolean.FALSE.valueOf(Handler.Result);
        else isInstalled = false;
    }

    public static Boolean toDo(){
        return isInstalled;
    }

    public void install(String job){
        if (isInternet){
            File f = new File(Data.locationToInstall + job);
        }else{
            Logger.printLine("Please connect to internet first...");
        }
    }

    private static void checkInternet(){
        try {
            URL url = new URL(Data.BaseUrl);
            URLConnection connection = url.openConnection();
            connection.connect();
            isInternet = true;
        } catch (Exception e) {
            isInternet = false;
        }
    }

    public static boolean check(String string, String job1, String job2) {
        if (containsIgnoreCase(string, job1) || containsIgnoreCase(string, job2)) return true;
        return false;
    }

    private static boolean containsIgnoreCase(String src, String what) {
        final int length = what.length();
        if (length == 0)
            return true; // Empty string is contained

        final char firstLo = Character.toLowerCase(what.charAt(0));
        final char firstUp = Character.toUpperCase(what.charAt(0));

        for (int i = src.length() - length; i >= 0; i--) {
            // Quick check before calling the more expensive regionMatches() method:
            final char ch = src.charAt(i);
            if (ch != firstLo && ch != firstUp)
                continue;

            if (src.regionMatches(true, i, what, 0, length))
                return true;
        }

        return false;
    }
}
