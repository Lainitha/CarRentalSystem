package carrentalsystem.controller;

import carrentalsystem.model.operation;
import carrentalsystem.model.Database;
import carrentalsystem.model.User;
import java.util.Scanner;


public class UpdateCar implements operation {

    @Override
    public void operation(Database database , Scanner s, User user) {

        System.out.println("Enter car ID (int):(-1 to show all cars)");
        int id = s.nextInt();

        String update ="UPDATE `cars` SET `brand`='[value-2]',`model`='[value-3]',`color`='[value-4]',`year`='[value-5]',`price`='[value-6]',`available`='[value-7]' WHERE `id` ='';";


    }
    
}
