package com.mycompany.login_app;

import java.util.Scanner;

public class Login_App {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        String username, password, phone;

        // Prompting the user for a valid username
        do {
            System.out.print("Enter username (It must  be 5 characters or less and must contain underscore ): ");
            username = scanner.nextLine();
        } while (!login.checkUserName(username));

        // Prompting the user for a valid password
        do {
            System.out.print("Enter password (Must at least 8 characters, a capital, a number, a special char): ");
            password = scanner.nextLine();
        } while (!login.checkPasswordComplexity(password));

        // Prompting the user for a valid phone number
        do {
            System.out.print("Enter cell phone number (e.g., +27123456789): ");
            phone = scanner.nextLine();
        } while (!login.checkCellPhoneNumber(phone));

     
        String registrationMessage = login.registerUser(username, password, phone);
        System.out.println(registrationMessage);

        
        System.out.print("\nLogin now.\nEnter username: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();

        boolean loginSuccess = login.loginUser(loginUsername, loginPassword);
        System.out.println(login.returnLoginStatus(loginSuccess));

        scanner.close();
    
    }
    //References
//[DeepAI Text Generator API](https://deepai.org/machine-learning-model/text-generator) - Used for generating AI-based content in this application.

}
