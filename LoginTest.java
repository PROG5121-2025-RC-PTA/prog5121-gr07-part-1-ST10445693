package com.mycompany.login_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testInvalidLoginWrongUsername() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&sec@ke99", "+27838968976");
        assertFalse(login.loginUser("wrong_user", "Ch&sec@ke99"));
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(false));
    }

    @Test
    public void testInvalidUsernameRegistration() {
        Login login = new Login();
        String result = login.registerUser("kyle!!!", "Ch&sec@ke99", "+27838968976");
        assertEquals("Registration failed. Please ensure all inputs are correctly formatted.", result);
    }
    
        @Test
    public void testInvalidLoginWrongPassword() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&sec@ke99", "+27838968976");
        assertFalse(login.loginUser("kyl_1", "wrongpassword"));
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(false));
    }


    @Test
    public void testInvalidPasswordRegistration() {
        Login login = new Login();
        String result = login.registerUser("kyl_1", "password", "+27838968976");
        assertEquals("Registration failed. Please ensure all inputs are correctly formatted.", result);
    }

    @Test
    public void testInvalidCellPhoneRegistration() {
        Login login = new Login();
        String result = login.registerUser("kyl_1", "Ch&sec@ke99", "08966553");
        assertEquals("Registration failed. Please ensure all inputs are correctly formatted.", result);
    }
    
    @Test
    public void testValidRegistration() {
        Login login = new Login();
        String result = login.registerUser("kyl_1", "Ch&sec@ke99", "+27838968976");
        assertEquals("User registered successfully.", result);
    }

    @Test
    public void testValidLogin() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&sec@ke99", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&sec@ke99"));
        assertEquals("Welcome kyl_1, it is great to see you again.", login.returnLoginStatus(true));
    }









}
