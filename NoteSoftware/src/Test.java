
import com.sun.corba.se.impl.orbutil.ObjectWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;


public class Test {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
         
         File inputFile = new File("test.txt"); // The file to store and retrieve 
         FileOutputStream fileStream = new FileOutputStream(inputFile); // File output stream
         ObjectOutputStream objectStream = new ObjectOutputStream(fileStream); // Object output stream
         
         Car bmw = new Car("BMW", 2015, 4);
         objectStream.writeObject(bmw);   // Writing object into file
         objectStream.close();            // Closing the object stream
         
         FileInputStream inFile = new FileInputStream(inputFile);
         ObjectInputStream objectIn = new ObjectInputStream(inFile);
         
         Car bmw_retrive = (Car) objectIn.readObject();
         System.out.println("Car Model       : " + bmw_retrive.getCarModel());
         System.out.println("Made in Year of : " + bmw_retrive.getYearMade());
         System.out.println("Number of Tires : " + bmw_retrive.numberOfTires);
         System.out.println("Quantity        : " + Car.quantity);
         
         objectIn.close();  // closing the object stream
         
        
    }
    
}

class Car implements Serializable{
    private String carModel;
    static int quantity;
    public final int numberOfTires;
    private int yearMade;
    public Car(String carModel, int yearMade, int numOfTires){
        this.carModel = carModel;
        this.yearMade = yearMade;
        this.numberOfTires = numOfTires;
    }
    public String getCarModel(){return carModel;}
    public int getYearMade(){return yearMade;}
}
