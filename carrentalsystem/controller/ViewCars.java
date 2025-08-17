package carrentalsystem.controller;

import carrentalsystem.model.Database;
import carrentalsystem.model.operation;
import carrentalsystem.model.User;
import carrentalsystem.model.Car;

import java.util.Scanner;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewCars implements operation {

    @Override
    public void operation(Database database, Scanner s, User user) {
        System.out.println(" ");
        String select = "SELECT * FROM `cars`;";
        ArrayList<Car> cars = new ArrayList<>();
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            while (rs.next()) {
                Car car = new Car();
                car.setID(rs.getInt("id"));
                car.setBrand(rs.getString("brand"));   // ✅ fixed
                car.setModel(rs.getString("model"));
                car.setColor(rs.getString("color"));
                car.setYear(rs.getInt("year"));
                car.setPrice(rs.getDouble("price"));
                car.setAvailable(rs.getInt("available"));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Car c : cars) {
            if (c.isAvailable() < 2) {   // ✅ fixed
                System.out.println("---------------");
                System.out.println("ID:\t" + c.getID());
                System.out.println("Brand:\t" + c.getBrand());
                System.out.println("Model:\t" + c.getModel());
                System.out.println("Year:\t" + c.getYear());
                System.out.println("Price:\t" + c.getPrice() + " $");
                
                if (c.isAvailable() == 0) {
                    System.out.println("Status:\tAvailable");
                } else {
                    System.out.println("Status:\tNot Available");
                }
                System.out.println("-----------\n");
            }
        }
        System.out.println();
    }
}
