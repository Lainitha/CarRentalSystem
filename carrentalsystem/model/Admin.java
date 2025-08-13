package carrentalsystem.model;
import java.util.Scanner;

import carrentalsystem.controller.AddNewAccount;


public class Admin extends User{

    private operation[] operations = new operation[] { new AddNewAccount(1)};

    public Admin(){
        super();
    }

    @Override
    public void showList(Database database, Scanner s) {
        System.out.println("\n1. Add New Car");
        System.out.println("2. View  Cars");
        System.out.println("3. Update Car");
        System.out.println("4. Delete Car");
        System.out.println("5. Add New Admin");
        System.out.println("6. Show Rents");
        System.out.println("7.Quit\n");

    }
    
}
