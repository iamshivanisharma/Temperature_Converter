package com.shivani.javafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MyController implements Initializable {
	@FXML
	public Label welcomeLabel;
	@FXML
	public ChoiceBox<String> choicebox;
	@FXML
	public TextField userInputField;
	@FXML
	public Button convertBtn;
private static final String C_F_TEXT="Celsius to Fahrenheit";
private static final String F_C_TEXT="Fahrenheit to Celsius";
private boolean isC_to_F=true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choicebox.getItems().add(C_F_TEXT); //all element should belong to same class
		choicebox.getItems().add(F_C_TEXT);
		choicebox.setValue(C_F_TEXT);//default value
		choicebox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
		{
			if(newValue.equals(C_F_TEXT)) {
				isC_to_F = true;
			}
			else{
				isC_to_F=false;
			}
		});
//		choicebox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				System.out.println(newValue);
//			}
//		});
		convertBtn.setOnAction(event -> {
			convert();
		});
//		convertBtn.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				System.out.println("Button Clicked");
//			}
//
//		});
		}

	private void convert() {
		float enteredTemperature=0.0f;
		String input=userInputField.getText();
		try{

			enteredTemperature=Float.parseFloat(input);
		}
		catch(Exception e){
warnUser();
return;
//no code executed
		}
		float enteredTemp=Float.parseFloat(input);
		float newTemperature=0.0f;
		if(isC_to_F){
			newTemperature=(enteredTemp*9/5)+32;

		}
		else{
			newTemperature=(enteredTemp-32)*5/9;
		}
		display(newTemperature);
	}

	private void warnUser() {
		Alert alert=new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occurred");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please enter a valid temperature");
		alert.show();

	}

	private void display(float newTemperature) {
		String unit=isC_to_F? "F":"C";
		System.out.println("The new temperature is: "+newTemperature+unit);
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new temperature is: "+newTemperature+unit);
		alert.show();

	}
}

