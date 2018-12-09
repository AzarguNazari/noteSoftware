
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Hazar Gul
 */
public class NoteSoftware extends Application {

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

//        stage.setOnHiding(new EventHandler<WindowEvent>() {
//
//            @Override
//            public void handle(WindowEvent event) {
//                Platform.runLater(new Runnable() {
//
//                    @Override
//                    public void run() {
//                       
//
//                    }
//                });
//            }
//        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
