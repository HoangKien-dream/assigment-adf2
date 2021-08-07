package java_adf2;

import java_adf2.controller.EmployeesControllerImplement;
import java_adf2.model1.EmployeesModelImplement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeesControllerImplement employeesControllerImplement = new EmployeesControllerImplement();
        while (true){
            System.out.printf("Employees Manager\n");
            System.out.printf("--------------------\n");
            System.out.printf("1. Create new account.\n");
            System.out.printf("2. Login. \n");
            System.out.printf("3. Exit Program\n");
            System.out.printf("--------------------\n");
            System.out.printf("Please enter your choice (1-3): \n");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    employeesControllerImplement.createAccount();
                    break;
                case 2:
                    employeesControllerImplement.login();
                    break;
                case 3:
                    System.out.println("Exit program");
                    break;
                default:
                    System.out.printf("Please choice again (1-3)");
                    break;
            }
            scanner.nextLine();
            if (choice == 3){
                break;
            }
        }
    }
}
