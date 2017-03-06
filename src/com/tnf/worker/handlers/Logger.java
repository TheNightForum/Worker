package com.tnf.worker.handlers;

/**
 * Created by brayden on 6/3/17.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    public static final String NORMAL =  "       ";
    public static final String WARNING = "WARNING";
    public static final String ERROR =   "!ERROR!";
    private static final String DEBUG =  "DEBUG";
    private static final String UNZIP = "UNZIP";
    private static boolean debugEnabled = false;

    public static void printDebug(String inputString, String inputType){
        if (debugEnabled){
            System.out.println(" " + inputType + " |: " + DEBUG + " - " + inputString);
        }
    }

    public static void printDebug(String inputString){
        if (debugEnabled){
            System.out.println("         |: " + DEBUG + " - " + inputString);
        }
    }

    public static void print(String inputString) {
        System.out.print("| " + inputString);
    }

    public static void printLine(String inputString) {
        System.out.println("| " + inputString);
    }

    public static void printLine(String inputString, String inputType) {
        if (inputType.equals(UNZIP)){
            System.out.println(" " + inputType + "   | " + inputString);
        }else {
            System.out.println(" " + inputType + " | " + inputString);
        }
    }

    private static void log(String message) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("output.txt", true), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.write(message);
        out.close();
    }

    public static void printLine(Exception e){
        System.out.println(" " + ERROR + " | " + e);
    }

    public static void printLine(int inputInt) {
        printLine(Integer.toString(inputInt));
    }

    public static void enabledDebug(){
        debugEnabled = true;
    }

    public static boolean isInDebug(){
        return debugEnabled;
    }

    public static void printLine() {
        printLine("");
    }
}