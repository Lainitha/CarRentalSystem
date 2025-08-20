package carrentalsystem.controller;

import carrentalsystem.model.Database;
import carrentalsystem.model.User;
import carrentalsystem.model.operation;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import carrentalsystem.model.Car;




public class UpdateCar implements operation {

    @Override
    public void operation(Database database , Scanner s, User user) {

        System.out.println("Enter car ID (int):(-1 to show all cars)");
        int id = s.nextInt();
        while(id ==-1) {
            new ViewCars().operation(database ,s,user);
                    System.out.println("Enter car ID (int):(-1 to show all cars)");
                    id = s.nextInt();
            

        }

        try {
            ResultSet rs1 = database.getStatement().executeQuery("SELECT * FROM `cars` WHERE `id`='"+id+"';");
            rs1.next();
            Car car = new Car();
            car.setID(rs1.getInt("id"));
            car.setBrand(rs1.getString("brand"));
            car.setModel(rs1.getString("model"));
            car.setColor(rs1.getString("color"));
            car.setYear(rs1.getInt("year"));
            car.setPrice(rs1.getDouble("price"));
            car.setAvailable(rs1.getInt("available"));

            if (car.isAvailable()>1){
                System.out.println("Car doesnt exist");
                return;
            }
            System.out.println("Enter Brand:(-1:" +car.getBrand()+")");
            String brand = s.next();
            if (brand.equals("-1")) brand =car.getBrand();
            System.out.println("Enter Model: (-1:"+car.getModel()+")");
            String model = s.next();
            if (model.equals("-1")) model = car.getModel();
            System.out.println("Enter Color (-1:"+ car.getColor()+")");
            String color = s.next();
            if (color.equals("-1")) color = car.getColor();
            
            System.out.println("Enter Year: (-1:"+car.getYear()+")");
            int year = s.nextInt();
            if (year==-1) year = car.getYear();

            System.out.println("Enter Price (double):(-1: "+car.getPrice()+")");
            double price = s.nextDouble();
            if  (price == -1) price = car.getPrice();


            String update ="UPDATE `cars` SET `brand`='"+brand+"',`model`='"+model+"',`color`='"+color+"',`year`='"+year+"',`price`='"+price+"'  WHERE `id` ='"+id+"';";

            database.getStatement().execute(update);
            System.out.println("Car successfully updated");
        
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
    }
    
}
