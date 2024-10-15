package com.pluralsight.FormatDates;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void main(String[] args) throws IOException {
        boolean looper = true;
        while (looper) {

            Scanner input = new Scanner(System.in);
            System.out.println("""
                    Hey,please choose one of the options "Launch" "Search" or "Exit":
                    -Launch the Application
                    -Searching For a Term
                    -Exit the Application:
                                    
                    """);
            String answer = input.nextLine();
            FileReader fileReader = new FileReader("src/main/resources/logs.txt/");
            BufferedReader bufReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("src/main/resources/logs.txt/", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            LocalDateTime today = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern(" yyyy-MM-dd KK:mm");
            String ftc = today.format(fmt);
            bufferedWriter.write(String.format("Date: %-20s " + " " + "Keystroke: %30s\n ", ftc, answer));


            if (answer.equalsIgnoreCase("Launch")) {
                //bufferedWriter.write(String.format(" Date: %-20s " + " "+ "Keystroke: %s\n ",ftc,answer));

            }
            if (answer.equalsIgnoreCase("Search")) {
                //bufferedWriter.write(String.format(" Date: %-20s " + " "+ "Keystroke: %s\n ",ftc,answer));
                System.out.println("Please Enter the search Term (X to exit)");
                String choice = input.nextLine();
                bufferedWriter.write(String.format("Date: %-20s " + " " + "Keystroke: %30s " + ": %10s\n", ftc, answer, choice));

                if (choice.equalsIgnoreCase("x")) {

                    System.out.println("Program Exited");
                    looper = false;


                }
                bufferedWriter.close();


            }
            if (answer.equalsIgnoreCase("Exit")) {
                System.out.println("Program Exited");
                looper = false;
            }
            bufferedWriter.close();
        }
    }
}
