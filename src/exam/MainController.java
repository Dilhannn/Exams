package exam;

import javafx.collections.FXCollections;
import java.lang.String;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class MainController {

	
	@FXML
	private ChoiceBox schoolmanagementorStudent;

	
	@FXML
	private Button schoolmanagementorStudentBtn;

	
	
	@FXML
	public void chooseSchoolmanagementorStudentButton(ActionEvent event) throws IOException {
		Window owner = schoolmanagementorStudentBtn.getScene().getWindow();
		if (schoolmanagementorStudent.getValue() == null) {
			AlertHelperExam.showAlert(Alert.AlertType.INFORMATION, owner, "Choose", "Please select title");
			return;
		}

		if (schoolmanagementorStudent.getValue().equals("School Managemet")) {
			Parent schoolmanagementloginParent = FXMLLoader.load(getClass().getResource("schoolmanagementlogin.fxml"));
			Scene scene = new Scene(schoolmanagementloginParent);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();

		}
		else {
			Parent loginexamParent = FXMLLoader.load(getClass().getResource("loginexam.fxml"));
			Scene scene = new Scene(loginexamParent);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();

		}

	}

	
}

