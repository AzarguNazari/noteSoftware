
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Test {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        File file = new File("test.txt");
        
        BufferedReader reader = new BufferedReader(new FileReader(file));
        PrintWriter output = new PrintWriter(file);
        
        
        reader.close();
        output.close();
    }
    
}
