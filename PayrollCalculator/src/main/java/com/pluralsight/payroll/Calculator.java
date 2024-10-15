package com.pluralsight.payroll;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter the name of the Employees file: ");
        String timeCard = scanner.nextLine();
        System.out.println(" Enter the name of the payroll file you would like to create: ");
        String payrollFile = scanner.nextLine();

        FileReader fileReader = new FileReader("src/main/resources/"+ timeCard);
        BufferedReader bufReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("src/main/resources/"+ payrollFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


        String input = bufReader.readLine();
        ArrayList<Employee> newEmployees2 = new ArrayList<>();
        int counter = 0;
        System.out.printf("""
                        %-18s  %2s  %10s
                                           
                        """,
                "Employee Name", "ID", "Gross Pay");
        while ((input = bufReader.readLine()) != null) {


            // String [] newEmployees = input.split(Pattern.quote("|"));
            String[] newEmployees = input.split("\\|");
            Employee employeList = new Employee(Integer.parseInt(newEmployees[0]), (newEmployees[1]), Double.parseDouble(newEmployees[2]), Double.parseDouble(newEmployees[3]));
            newEmployees2.add(employeList);
            // System.out.println(newEmployees2.get(counter));
            System.out.printf("""
                    %-18s  %2d     $%7.2f
                    """, newEmployees2.get(counter).getName(), newEmployees2.get(counter).getEmployeeid(), newEmployees2.get(counter).getGrosspay());

            bufferedWriter.write(String.format("ID: %-20d" + "|" + "Name: %s" + "|" + "Pay: %f\n",newEmployees2.get(counter).getEmployeeid(),newEmployees2.get(counter).getName(), newEmployees2.get(counter).getGrosspay()));
            counter++;

        }
        bufferedWriter.close();



    }
}
