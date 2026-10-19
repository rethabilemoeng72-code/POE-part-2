/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatbox.st10489935;

import java.util.Scanner;
/**
 *
 * @author Student
 */
public class ChatBoxST10489935 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login loginSystem = new Login();
        
        System.out.println("---Register New Account---");
        System.out.println("Enter Your First Name: ");
        String firstName = scanner.nextLine();
        
        System.out.println("Enter Your Last Name: ");
        String lastName = scanner.nextLine();
        
        System.out.println("Enter Username: ");
        String username = scanner.nextLine();
        
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        
        System.out.println("Enter Your Cellphone Number: ");
        String cellNumber = scanner.nextLine();
        
        // Check phone number separately
        if (!loginSystem.checkCellPhoneNumber(cellNumber)) {
            System.out.println("Does not have international code or cellphone number is incorrectly formatted");
        } else{
            System.out.println("Cellphone number successully registered.");
        }
        
        //Attempt Registration
        String registrationResult = loginSystem.registerUser(username, password, firstName, lastName);
        System.out.println(registrationResult);
        
        //Proceed to login if registration successful
        if (registrationResult.contains("successfully")) {
            System.out.println("\n---Login To Your Account---");
            System.out.println("Enter Username: ");
            String loginUser = scanner.nextLine();
            
            System.out.println("Enter Password: ");
            String loginPass = scanner.nextLine();
            
            boolean isMatch = loginSystem.loginUser(loginPass, loginUser);
            System.out.println(loginSystem.returnLoginStatus(isMatch));
        }
        
        scanner.close();
        
    }
}
