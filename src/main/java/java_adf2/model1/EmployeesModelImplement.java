package java_adf2.model1;

import java_adf2.employees.Employees;
import java_adf2.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeesModelImplement implements EmployeesModel {
    Scanner scanner = new Scanner(System.in);
    Employees employees = new Employees();
    public boolean register(Employees employees) {
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null){
                System.out.println("Can not connection to database");
                return false;
            }
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("insert into employees");
            sqlBuilder.append(" ");
            sqlBuilder.append("(name, address, email, account, password, createdAt, updatedAt, status)");
            sqlBuilder.append(" ");
            sqlBuilder.append("values");
            sqlBuilder.append(" ");
            sqlBuilder.append("(?, ?, ?, ?, ?, ?, ?, ?)");
            PreparedStatement preparedStatement = cnn.prepareStatement(sqlBuilder.toString());
            preparedStatement.setString(1, employees.getName());
            preparedStatement.setString(2, employees.getAddress());
            preparedStatement.setString(3, employees.getEmail());
            preparedStatement.setString(4, employees.getAccount());
            preparedStatement.setString(5, employees.getPassword());
            preparedStatement.setString(6, employees.getUpdatedAtString());
            preparedStatement.setString(7, employees.getCreatedAtString());
            preparedStatement.setInt(8, employees.getStatus());
            preparedStatement.execute();
            System.out.println("Register Success!!");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }
        return false;
    }

    @Override
    public boolean checkExistAccount(String account) {
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null){
                System.out.println("Can not connection to database");
                return false;
            }
            PreparedStatement preparedStatement = cnn.prepareStatement(String.format("select account from employees where account = '%s' ",account));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                if (resultSet.getString("account").equals(account))
                System.out.println("Account Exist!!");
                return true;
            }else {
                System.out.println("Account not Exist!!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }
        return false;
    }

    @Override
    public Employees login(String account, String password) {
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null){
                System.out.println("Can not connection to database");
            }
            PreparedStatement preparedStatement = cnn.prepareStatement(String.format("select * from employees where account = '%s' and password = '%s' ", account,password));
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()){
                System.out.println("Login Success!!");
                System.out.println("--- Information account ---");
                System.out.println("");
                System.out.printf("%10s%10s%10s | %10s%15s%10s | %5s%15s%5s | %5s%10s%18s | %5s%20s%5s | %5s%20s%5s | %5s%5s%5s |  \n",
                        "", "Account", "",
                        "", "Name", "",
                        "", "Address", "",
                        "", "Email", "",
                        "", "CreatedAt", "",
                        "", "UpdatedAt", "",
                        "", "Status", "");
                System.out.printf("%10s%10s%10s | %10s%15s%10s | %5s%15s%5s | %5s%10s%10s | %5s%20s%5s | %5s%20s%5s | %5s%5s%5s |  \n",
                        "", result.getString("account"), "",
                        "", result.getString("name"), "",
                        "", result.getString("address"), "",
                        "", result.getString("email"), "",
                        "", result.getDate("createdAt"), "",
                        "", result.getDate("updatedAt"), "",
                        "", result.getInt("status"), "");
            }else {
                System.out.println("Login Failed!!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }
        return null;
    }
}
