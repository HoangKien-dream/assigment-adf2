package java_adf2.employees;

import java_adf2.util.DateTimeUtil;

import java.util.Calendar;
import java.util.Date;

public class Employees {
    private String name;
    private String address;
    private String email;
    private String account;
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private int status;

    public Employees() {
    }

    public Employees(String name, String address, String email, String account, String password, int status) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.account = account;
        this.password = password;
        this.createdAt = Calendar.getInstance().getTime();
        this.updatedAt = Calendar.getInstance().getTime();
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%5s%8s%5s | %1s%21s%14s | %5s%30s%15s | %8s%10s%7s | %5s%15s%5s | %5s%15s%5s | %5s%10s%5s | %5s%10s%5s\n",
                "",account, "",
                "",password, "",
                "",name, "",
                "",email, "",
                "",address, "",
                "",getCreatedAtString(), "",
                "",getUpdatedAtString(), "",
                "",status, "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreatedAtString() {
        return DateTimeUtil.formatDateToString(this.createdAt);
    }

    public String getUpdatedAtString() {
        return DateTimeUtil.formatDateToString(this.updatedAt);
    }
}
