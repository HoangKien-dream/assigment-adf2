package java_adf2.controller;

import java_adf2.employees.Employees;
import java_adf2.model1.EmployeesModelImplement;

import java.util.Scanner;

public class EmployeesControllerImplement implements EmployeesController {
    EmployeesModelImplement employeesModelImplement = new EmployeesModelImplement();

    @Override
    public void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Create new account ---");
        System.out.println("Please enter your account: ");
        String account = scanner.nextLine();
        if (employeesModelImplement.checkExistAccount(account)==false){
            System.out.println("Please enter your password: ");
            String password = scanner.nextLine();
            if(password.length()<4){
                System.out.println("Please enter your password at least 5 character: ");
                password = scanner.nextLine();
            }
            System.out.println("Please enter your name: ");
            String name = scanner.nextLine();
            if(name.length()<4){
                System.out.println("Please enter your name at least 5 character: ");
                name = scanner.nextLine();
            }
            System.out.println("Please enter your address: ");
            String address = scanner.nextLine();
            if(address.length()<4){
                System.out.println("Please enter your address at least 5 character: ");
                address = scanner.nextLine();
            }
            System.out.println("Please enter your email: ");
            String email = scanner.nextLine();
            if(email.length()<10){
                System.out.println("Please enter your email with format(hoangkien@gmail.com): ");
                email = scanner.nextLine();
            }
            Employees employees = new Employees(name, address, email, account, password, 1);
            employeesModelImplement.register(employees);
        }else {
            System.out.println("Please enter again!!! ");
        }
    }

    @Override
    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Login ---");
        System.out.println("Please enter your account: ");
        String account = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
        if (employeesModelImplement.checkExistAccount(account)){
            employeesModelImplement.login(account,password);
        }
    }
}
