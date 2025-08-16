package carrentalsystem.controller;

import carrentalsystem.model.operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import carrentalsystem.model.Database;
import carrentalsystem.model.User;



public class AddNewCar implements operation {

    @Override
    public void operation(Database database, Scanner s, User user) {

        System.out.println("Enter brand:");
        String brand =s.next();
        System.out.println("Enter model:");
        String model = s.next();
        System.out.println("Enter color:");
        String color = s.next();
        System.out.println("Enter year (int):");
        int year = s.nextInt();
        System.out.println("Enter price per hour (double):");
        double price = s.nextDouble();
        int available = 0;

        try {
            ResultSet rs = database.getStatement().executeQuery(
                "SELECT COALESCE(MAX(id), 0) AS max_id FROM `cars`;"
            );
            rs.next();
            int id = rs.getInt("max_id") + 1;

            String insert = "INSERT INTO `cars`(`id`, `brand`, `model`, `color`, `year`, `price`, `available`) VALUES ('" + id + "','" + brand + "','" + model + "','" + color + "','" + year + "','" + price + "','" + available + "')";
            
            database.getStatement().execute(insert);
            System.out.println("Car added Successfully!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
}
