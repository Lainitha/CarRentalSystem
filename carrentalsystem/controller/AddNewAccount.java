package carrentalsystem.controller;

import carrentalsystem.model.Client;
import carrentalsystem.model.Database;
import carrentalsystem.model.User;
import carrentalsystem.model.operation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class AddNewAccount implements operation {
    private int accType;

    public AddNewAccount(int accType){
        this.accType=accType;
    }

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
        
        try {
            ArrayList<String> existingEmails = new ArrayList<>();
            ResultSet rs0 = database.getStatement().executeQuery("SELECT `email` FROM `users`;");
            while (rs0.next()){
                existingEmails.add(rs0.getString("email"));
            }

            if (existingEmails.contains(email)){
                System.out.println("Email already exists. Please try again.");
                return;
            }
            ResultSet rs = database.getStatement().executeQuery("SELECT COUNT(*) FROM `users`;"); 
            rs.next();
            int id = rs.getInt("Count(*)");
            
            String insert = "INSERT INTO `users` (`id`, `firstName`, `lastName`, `email`, `phoneNumber`, `password`, `type`) VALUES (" + id + ", '" + firstName + "', '" + lastName + "', '" + email + "', '" + phoneNumber + "', '" + password + "', " + accType + ");";
            database.getStatement().executeUpdate(insert);
            System.out.println("New account created successfully.");

            if (accType ==0){
                user = new Client();

                user.setId(id);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                user.setPhoneNumber(phoneNumber);
                user.setPassword(password);
                user.showList(database,s);


            }

            
            
            
        }catch (SQLException e) {
            e.printStackTrace();
        }


        




    } 
    
    
}
