package carrentalsystem.model;
import java.util.Scanner;

public abstract class User {

    private int id;
    private  String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;


    //type 0==> Client
    //type 1==> Admin
    //type 2==> DeletedClinetAccount
    //type 3==> DeletedAdminAccount

    public User(){

    }

    public int getId(){
        return id;
    }
    public void setId(int id){


    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;

    }

    public String getEmail(){
        return email;
    
    }

    public void setEmail(String email){
        this.email=email;


    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public abstract void showList(Database database, Scanner s);



}
