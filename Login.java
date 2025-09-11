/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login_app;

import java.util.regex.Pattern;

public class Login {

    private String username;
    private String password;
    private String cellPhoneNumber;

    public boolean checkUserName(String username) {
        if (username.contains("_") && username.length() <= 5) {
            System.out.println("Username successfully captured.");
            return true;
        } else {
            System.out.println("Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than five characters in length.");
            return false;
        }
    }

    public boolean checkPasswordComplexity(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        if (Pattern.matches(passwordRegex, password)) {
            System.out.println("Password successfully captured.");
            return true;
        } else {
            System.out.println("Password is not correctly formatted. It must contain at least eight characters, a uppercase letter, a number, and a special character.");
            return false;
        }
    }

    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        String phoneRegex = "^\\+\\d{1,3}\\d{7,10}$";
        if (Pattern.matches(phoneRegex, cellPhoneNumber)) {
            System.out.println("Cell phone number successfully captured.");
            return true;
        } else {
            System.out.println("please use the correctly format. Make sure it includes the international code (e.g., +27...).");
            return false;
        }
    }

    public String registerUser(String username, String password, String cellPhoneNumber) {
        boolean isUsernameValid = checkUserName(username);
        boolean isPasswordValid = checkPasswordComplexity(password);
        boolean isPhoneValid = checkCellPhoneNumber(cellPhoneNumber);

        if (isUsernameValid && isPasswordValid && isPhoneValid) {
            this.username = username;
            this.password = password;
            this.cellPhoneNumber = cellPhoneNumber;
            return "User registered successfully.";
        } else {
            return "Registration failed. Please ensure all inputs are correctly formatted.";
        }
    }

    public boolean loginUser(String username, String password) {
        return this.username != null && this.password != null &&
               this.username.equals(username) && this.password.equals(password);
    }

    public String returnLoginStatus(boolean loginStatus) {
        return loginStatus ? "Welcome " + this.username + ", it is great to see you again."
                           : "Username or password incorrect, please try again.";
    }
}
