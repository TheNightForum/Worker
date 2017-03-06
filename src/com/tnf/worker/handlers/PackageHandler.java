package com.tnf.worker.handlers;

/**
 * Created by brayden on 6/3/17.
 */
public class PackageHandler {
    public String getCreator(String job){
        Handler.readPackage(job, Handler.P_Creator);
        return String.valueOf(Handler.Result);
    }
    public int getVersion(String job){
        Handler.readPackage(job, Handler.P_Version);
        return Integer.valueOf(Handler.Result);
    }
    public String getName(String job){
        Handler.readPackage(job, Handler.P_Name);
        return String.valueOf(Handler.Result);
    }
    public String getURL(String job){
        Handler.readPackage(job, Handler.P_DownloadURL);
        return String.valueOf(Handler.Result);
    }
    public Boolean getIsZip(String job){
        Handler.readPackage(job, Handler.P_IsZip);
        return Boolean.valueOf(Handler.Result);
    }
    public String getZipDIR(String job){
        Handler.readPackage(job, Handler.P_ZipDir);
        return String.valueOf(Handler.Result);
    }
    public String getZipURL(String job){
        Handler.readPackage(job, Handler.P_ZipURL);
        return String.valueOf(Handler.Result);
    }
    public String getLibs(String job){
        Handler.readPackage(job, Handler.P_NeedsLibs);
        return String.valueOf(Handler.Result);
    }
    public String getShell(String job){
        Handler.readPackage(job, Handler.P_ShellScript);
        return String.valueOf(Handler.Result);
    }
    public String getShellDir(String job){
        Handler.readPackage(job, Handler.P_ShellDir);
        return String.valueOf(Handler.Result);
    }
}
