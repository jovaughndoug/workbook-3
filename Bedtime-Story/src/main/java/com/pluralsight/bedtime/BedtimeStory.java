package com.pluralsight.bedtime;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedtimeStory {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);


        System.out.println("""
                Please Select on of the following Stories:
                              1 for "goldilocks"
                              2 for "Hansel and Gretel"
                              3 for "Mary had a little Lamb"
                """);

        int choice = input.nextInt();
        if(choice == 1) {
            storyReader("goldilocks.txt");
        }
         if(choice == 2) ;
        {
            storyReader("hansel_and_gretel.txt");}
         if(choice == 3);
        {
            storyReader("mary_had_a_little_lamb.txt");

        }


    }


    public static void storyReader(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("./src/main/resources/" + fileName);
        Scanner fileScanner = new Scanner(fis);

        while (fileScanner.hasNextLine()) {
            String input = fileScanner.nextLine();
            System.out.println(input);
        }
    }
}




