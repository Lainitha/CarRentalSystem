package carrentalsystem.model;
import carrentalsystem.controller.AddNewAccount;
import carrentalsystem.controller.AddNewCar;
import carrentalsystem.controller.ViewCars;
import java.util.Scanner;



public class Admin extends User{

    private operation[] operations = new operation[] {new AddNewCar(), new ViewCars() , new AddNewAccount(1)};
    private Scanner s;

    public Admin(){
        super();
    }

    @Override
    public void showList(Database database, Scanner s) {
        System.out.println("\n1. Add New Car");
        System.out.println("2. View  Cars");
        // System.out.println("3. Update Car");
        // System.out.println("4. Delete Car");
        System.out.println("3. Add New Admin");
        // System.out.println("6. Show Rents");
        // System.out.println("7.Quit\n");

    

        int i = s.nextInt();
        s.nextLine();
        operations[i-1].operation(database, s, this);
        showList(database, s);
    
}
}


