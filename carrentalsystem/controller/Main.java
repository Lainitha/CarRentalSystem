package carrentalsystem.controller;

import carrentalsystem.model.Admin;
import carrentalsystem.model.Client;
import carrentalsystem.model.Database;
import carrentalsystem.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Scanner s = new Scanner(System.in);



        System.out.println("Welcome to the Car Rental System!");
        System.out.println("Enter your email:\n -1 to create a new account");
        String email = s.next();
        if (email.equals("-1")) {
            new AddNewAccount(1).operation(database, s,null);
            return;
        }
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

                if (type ==0) {
                    user = new Client();
                    user.setId(id);
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setEmail(em);
                    user.setPhoneNumber(phoneNumber);
                    user.setPassword(pass);
                    users.add(user);
                    //user.showList(database,s);
                }
                    
                else if (type==1) {
                    user = new Admin();
                    user.setId(id);
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setEmail(em);
                    user.setPhoneNumber(phoneNumber);
                    user.setPassword(pass);
                    users.add(user);
                    //user.showList(database, s);
                } 
                

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        boolean loggedIn = false;
        
        for (User u : users) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                System.out.println("Welcome " + u.getFirstName() + "!");
                loggedIn =true;
                u.showList(database, s);
                }        

            }
        if (!loggedIn){

            System.out.println("Email or password is incorrect.");
            s.close();
        }

    }}


