package carrentalsystem.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Rent {
    
    private int id;
    private User user;
    private Car car;
    private LocalDateTime dateTime;
    private int hours;
    private double total;
    private String status;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd--MM hh.mm");


    public Rent(){
        dateTime=LocalDateTime.now();
    }

    public int getId(){
        return id;

    }

    public void setId(int id){
        this.id=id;
    }
    public User getUser(){
        return user;

    }
    public void setUser(User user){
        this.user=user;
    }

    public Car getCar(){
        return car;
    }
    public void setCar(Car car){
        this.car=car;
    
    }

    public  LocalDateTime getDateTime(){
        return dateTime;
    }

    public void setDateTime(String dateTimeString){
        this.dateTime =LocalDateTime.parse(dateTimeString, formatter);
    }

    public int getHours(){
        return hours;
    }

    public void setHours(int hours){
        this.hours = hours;
    }
    
    public double getTotal(){
        return total;

    }

    public void setTotal(double total){
        this.total=total;
    }
    public String getStatus(){
        return status;
    }

    public void setStatus(String Status){
        this.status=status;
    }

    
}
