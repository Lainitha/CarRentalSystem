package carrentalsystem.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import carrentalsystem.model.Admin;
import carrentalsystem.model.Client;
import carrentalsystem.model.Database;
import carrentalsystem.model.User;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Scanner s = new Scanner(System.in);



        System.out.println("Welcome to the Car Rental System!");
        System.out.println("Enter your email:\n -1 to create a new account");
        String email = s.next();
        System.out.println("Enter password:");
        String password = s.next();

        ArrayList<User> users = new ArrayList<>();

        try {

            String select ="SELECT * FROM `users`;";
            ResultSet rs = database.getStatement().executeQuery(select);
            while (rs.next()){
                User user;
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String em = rs.getString("email"); 
                String phoneNumber = rs.getString("phoneNumber");
                String pass = rs.getString("password");
                int type = rs.getInt("type");
                switch (type) {
                    case 0:
                        user = new Client();
                        break;
                    case 1:
                        user = new Admin();
                        break;

                    default:
                        user = new Client();

                }
                user.setId(id);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(em);
                user.setPhoneNumber(phoneNumber);
                user.setPassword(pass);
                users.add(user);


            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        for (User u : users) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                System.out.println("Welcome " + u.getFirstName() + "!");
                u.showList(database, s);

            }
        }

    }

    
}
