package com.tnf.worker;

/**
 * Created by brayden on 6/3/17.
 */
import com.tnf.worker.handlers.Logger;

import java.util.Calendar;
import java.util.Scanner;

public class Main {

    private static boolean more = true;

    public static void main(String[] args){
        work();
    }
    public static void work() {
        // Initialization
        Scanner input = new Scanner(System.in);
        String response = "", job;
        Calendar cal = Calendar.getInstance();
        System.out.println("Welcome to Worker.");
        while(!response.equals("done")) {
            Logger.printLine("Job: ");
            job = input.nextLine();

            Logger.printLine("+------------------------------------------------------------------------------------------+");
            Logger.printLine("More Jobs? Please enter \"done\" to stop entering jobs or hit [ENTER] to continue.");
            Logger.printLine();
            response = input.nextLine();
        }
        input.close();
        System.out.println();
        System.out.println("Thank you for using Worker!");
    }

}