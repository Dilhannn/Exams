package exam;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import exam.pojo.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class SchoolManagementLoginController {

	 private static final String Parent = null;

	 @FXML
	 private ChoiceBox schoolmanagementorStudent;
   
	 @FXML
   private TextField userName;

   @FXML
   private Button submitButton;

   @FXML
   private TextField password;
   
   @FXML
   public void login(ActionEvent actionEvent) throws IOException {
       Window owner = submitButton.getScene().getWindow();
       try {

           FileReader fileReader = new FileReader(new File("files/schoolmanagementpassword"));
           BufferedReader br = new BufferedReader(fileReader);
           String line;
           List<Student> students = new ArrayList<>();
           while ((line = br.readLine()) != null) {
               Student student = new Student();

               student.setUsername(line.split(":")[0]);
               student.setPassword(line.split(":")[1]);
               students.add(student);
           }
           fileReader.close();
           boolean loginSucsess = false;
           for (int i = 0; i < students.size(); i++) {

           	if (students.get(i).getUsername().equals(userName.getText()) && students.get(i).getPassword().equals(password.getText())) {
                   loginSucsess = true;
                   
                   
                  
                   break;
               }
           }
           

           if (loginSucsess) {
           	
           	 AlertHelperExam.showAlert(Alert.AlertType.CONFIRMATION, owner, "Login",
                        "Successfully");
           	Parent schoolmanagementMenuParent = FXMLLoader.load(getClass().getResource("schoolmanagemetMenu.fxml"));
               Scene scene = new Scene(schoolmanagementMenuParent);
               Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
               stage.setScene(scene);
               stage.show(); 
                
           }
           if (!loginSucsess) {
               AlertHelperExam.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                       "Username or password incorrect");
               
              
				
           }
           
          } catch (Exception e) {
          e.printStackTrace();
       }
       
   }
                     
         
          
               
         
   }

