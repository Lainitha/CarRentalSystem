package carrentalsystem.model;
import carrentalsystem.controller.AddNewAccount;
import java.util.Scanner;



public class Admin extends User{

    private operation[] operations = new operation[] { new AddNewAccount(1)};
    private Scanner s;

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

    

        int i = s.nextInt();
        operations[0].operation(database, s, this);
        showList(database, s);
    
}
}


