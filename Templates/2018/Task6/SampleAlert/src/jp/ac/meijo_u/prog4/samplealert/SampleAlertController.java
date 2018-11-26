package jp.ac.meijo_u.prog4.samplealert;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class SampleAlertController {
	@FXML private Button buttonConfirmation;
	@FXML private Button buttonError;
	@FXML private Button buttonInformation;
	@FXML private Button buttonWarning;
	@FXML private Label labelMessage;
	
	@FXML
	public void handleButtonConfirmationAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("CONFIRMATION");
		alert.setHeaderText(null);
		alert.setContentText("Message");
		Optional<ButtonType> result = alert.showAndWait();
		// 確認ダイアログでクリックされたボタンを判別
		if (result.get() == ButtonType.OK) {
			labelMessage.setText("CONFIRMATION: OK");
		} else {
			labelMessage.setText("CONFIRMATION: Cancel");
		}
	}
	
	@FXML
	public void handleButtonErrorAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERROR");
		alert.setHeaderText(null);
		alert.setContentText("Message");
		Optional<ButtonType> result = alert.showAndWait();
		// 確認ダイアログでクリックされたボタンを判別
		if (result.get() == ButtonType.OK) {
			labelMessage.setText("ERROR: OK");
		}
	}
	
	@FXML
	public void handleButtonInformationAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("INFORMATION");
		alert.setHeaderText(null);
		alert.setContentText("Message");
		Optional<ButtonType> result = alert.showAndWait();
		// 確認ダイアログでクリックされたボタンを判別
		if (result.get() == ButtonType.OK) {
			labelMessage.setText("INFORMATION: OK");
		}
	}
	
	@FXML
	public void handleButtonWarningAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("WARNING");
		alert.setHeaderText(null);
		alert.setContentText("Message");
		Optional<ButtonType> result = alert.showAndWait();
		// 確認ダイアログでクリックされたボタンを判別
		if (result.get() == ButtonType.OK) {
			labelMessage.setText("WARNING: OK");
		}
	}
}
