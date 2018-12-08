/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

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
    private AnchorPane aboutMe;
    
    @FXML
    private ComboBox<String> fonts;
    
    private File openedFile;
    

    @FXML
    private void handleButtonAction(ActionEvent event) {

    }

    @FXML
    private void fontIncrease(ActionEvent event) {
        text.setFont(Font.font(text.getFont().getSize() + 1));
    }

    @FXML
    private void fontDecrease(ActionEvent event) {
        text.setFont(Font.font(text.getFont().getSize() - 1));
    }

    @FXML
    private void open(ActionEvent event) throws FileNotFoundException {
        openedFile = new FileChooser().showOpenDialog(null);

        if (openedFile != null) {
                text.clear();
                BufferedReader buff = new BufferedReader(new FileReader(openedFile));
                buff.lines().forEach(line -> text.appendText(line + "\n"));

            
        } else {
           
        }
    }

    @FXML
    private void close(ActionEvent event) {
        lineNumber.setFont(Font.font(text.getFont().getSize() - 1));
        text.setFont(Font.font(text.getFont().getSize() - 1));
    }

    @FXML
    private void save(ActionEvent event) throws FileNotFoundException {
        PrintWriter saveFile = new PrintWriter(openedFile);
        System.out.println(Arrays.toString(text.getText().split("\n")));
//        Arrays.stream(text.getText().split("\n")).forEach(x -> saveFile.println(x));
        saveFile.close();
    }
    
    @FXML
    private void undo(ActionEvent event) {

    }

    @FXML
    private void redo(ActionEvent event) {

    }
    
    @FXML
    private void print(ActionEvent event) {

    }
    
    @FXML
    private void aboutMe(ActionEvent event) {
        aboutMe.setVisible(false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        fonts.getItems().addAll(Font.getFamilies());
        text.setFont(Font.font("Consolas"));
        fonts.setPromptText(text.getFont().getName());
//         text.setFont(Font.font(""));
    }

}
