package java_adf2.model1;

import java_adf2.employees.Employees;

public interface EmployeesModel  {
    boolean register(Employees employees);
    boolean checkExistAccount(String account);
    Employees login (String account, String password);
}
