package carrentalsystem.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.util.Scanner;

import carrentalsystem.model.operation;
import carrentalsystem.model.Database;
import carrentalsystem.model.User;


public class AddNewClient implements operation {

    @Override
    public void operation(Database database, Scanner s, User user){
        System.out.println("Enter First Name:");
        String firstName = s.next();
        System.out.println("Enter Last Name:");
        String lastName = s.next();
        System.out.println("Enter Email:");
        String email = s.next();
        System.out.println("Enter Phone Number:");
        String phoneNumber = s.next();
        System.out.println("Enter Password:");
        String password = s.next();
        System.out.println("Confirm Password:");
        String confirmPassword = s.next();
        while (!password.equals(confirmPassword)){
            System.out.println("Password doesnt match");
            System.out.println("Enter Password:");
            password = s.next();
            System.out.println("Confirm Password:");
            confirmPassword = s.next();
            
        }
        int accType =1;
        try {
            
        } catch (SQLException e) {
            e.printStackTrace();
        }





    } 
    {
    }
    
}
