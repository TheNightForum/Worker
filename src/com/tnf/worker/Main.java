package com.tnf.worker;

/**
 * Created by brayden on 6/3/17.
 */
import com.tnf.worker.handlers.Handler;
import com.tnf.worker.handlers.Logger;
import com.tnf.worker.handlers.Worker;

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
        String response = "", job, selection;
        Calendar cal = Calendar.getInstance();
        Logger.printLine("############################################################################################");
        Logger.printLine("Welcome to Worker.");
        Logger.printLine("############################################################################################");
        Logger.printLine();
        while(!response.equals("done")) {
            Logger.print("Job: ");
            job = input.nextLine();
            Worker.main(job);
            Boolean isInstalled = Worker.toDo();
            if (isInstalled){
                Logger.print("Would you like to remove this application (yes/no)? ");
                selection = input.nextLine();
                if (Worker.check(selection, "y","yes")) Worker.remove(job);
            }else{
                Logger.print("Would you like to install this application (yes/no)? ");
                selection = input.nextLine();
                if (Worker.check(selection, "n", "no")) Worker.install(job);
            }

            Logger.printLine();
            Logger.printLine("############################################################################################");
            Logger.printLine("More Jobs? Please enter \"done\" to stop entering jobs or hit [ENTER] to continue.");
            Logger.print("> ");
            response = input.nextLine();
        }
        input.close();
        Logger.printLine();
        Logger.printLine("############################################################################################");
        Logger.printLine("Thank you for using Worker!");
        Logger.printLine("############################################################################################");
    }

}