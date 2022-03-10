package Model;

import java.util.ArrayList;

public class User {

    public static ArrayList<User> arrayUser = new ArrayList<>();

    String fullname;
    String username;
    String password;
    String phoneNumber;

    public User(String fullname, String username, String password, String phoneNumber) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
