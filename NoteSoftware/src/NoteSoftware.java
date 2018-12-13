
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Hazar Gul
 */
public class NoteSoftware extends Application {
    
    public static Config configure;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));

        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        stage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, event -> {
            // add your code here to handle the close event
            // use event.consume(); to prevent the application from closing
            Alert alert = new Alert(AlertType.CONFIRMATION, "Do you want to close ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                //do stuff
            } else if (alert.getResult() == ButtonType.CANCEL) {
                stage.show();
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        File configFile = new File("config.txt");
        if(!configFile.exists()){
            ObjectOutputStream configInput = new ObjectOutputStream(new FileOutputStream(configFile));
            configInput.writeObject(new Config());
            configInput.close();
        }
        
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(configFile));
        NoteSoftware.configure = (Config) input.readObject();
        input.close();
        
        launch(args);
    }

}

class Config implements Serializable{
    public final static int serialVersionUID = 100;
    private String theme;
    private String fontFamily;
    private int fontSize;
    public Config(){
        this("lightTheme", 16, "Consolas");
    }
    public Config(String theme, int fontSize, String fontFamily){
        this.theme = theme;
        this.fontFamily = fontFamily;
        this.fontSize = this.fontSize;
    }
    public String getTheme(){return theme;}
    public String getFontFamily(){return fontFamily;}
    public int getFontSize(){return fontSize;}
}