/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

/**
 *
 * @author Hazar Gul
 */
public class MainPage implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private MenuBar mainMenu;
    
    @FXML
    private TextArea text;
    
    @FXML
    private TextArea lineNumber;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       
    }
    
    @FXML
    private void fontIncrease(ActionEvent event) {
        lineNumber.setFont(Font.font(text.getFont().getSize() + 1));
        text.setFont(Font.font(text.getFont().getSize() + 1));
    }
    
    @FXML
    private void fontDecrease(ActionEvent event) {
        lineNumber.setFont(Font.font(text.getFont().getSize() - 1));
        text.setFont(Font.font(text.getFont().getSize() - 1));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lineNumber.setEditable(false);
       
    }    
    
}
