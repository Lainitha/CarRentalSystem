package carrentalsystem.controller;


import java.util.Scanner;
import java.sql.SQLException;


import carrentalsystem.model.operation;
import carrentalsystem.model.Database;
import carrentalsystem.model.User;


public class DeleteCar implements operation{

    @Override
    public void operation(Database database, Scanner s, User user) {
        System.out.println("Enter ID(int): (-1 to show all cars)");
        int id = s.nextInt();
        while (id == -1){
            new ViewCars().operation(database, s, user);
            System.out.println("Enter ID (int): (-1 to show all cars)");
            id = s.nextInt(); 
        }
        try {

            String update = "UPDATE `cars` SET `Available`='3' WHERE `id`='"+id+"';";
            database.getStatement().execute(update);
            System.out.println("Car deteled Sucessfully");

            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
}
