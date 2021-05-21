package com.shivani.javafx;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Mymain extends Application {
	public static void main(String[] args) {
		System.out.println("main");
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("Init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Start");
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));

		VBox rootNode = loader.load();
		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode);


		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();
	}

	private javafx.scene.control.MenuBar createMenu() {
//file menu
		javafx.scene.control.Menu fileMenu = new javafx.scene.control.Menu("File");
		MenuItem newMenuItem=new MenuItem("New");
		newMenuItem.setOnAction(event-> System.out.println("New Menu Item Clicked."));

		SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
		MenuItem quitMenuItem=new MenuItem("Quit");

		quitMenuItem.setOnAction(event->{
			Platform.exit();
			System.exit(0);
		});


		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
		//help menu
		javafx.scene.control.Menu helpMenu = new javafx.scene.control.Menu("Help");
		MenuItem aboutApp=new MenuItem("About");
		aboutApp.setOnAction(event->AboutApp());


		helpMenu.getItems().addAll(aboutApp);

		javafx.scene.control.MenuBar menuBar = new javafx.scene.control.MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);
		return menuBar;


	}
	private void AboutApp() {
		Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("Desktop Application");
		alertDialog.setHeaderText("Temperature Coverter");
		alertDialog.setContentText("This application converts temperature from Celsius to Fahrenheit or vice-versa.");
		ButtonType yesbtn=new ButtonType("Yes");
		ButtonType nobtn=new ButtonType("No");
		alertDialog.getButtonTypes().setAll(yesbtn,nobtn);
		Optional<ButtonType> clickedBtn=alertDialog.showAndWait();
		if(clickedBtn.isPresent() && clickedBtn.get()==yesbtn);
		{
			System.out.println("Yes button clicked");
		}
		if(clickedBtn.isPresent()&& clickedBtn.get()==nobtn)
		{
			System.out.println("No button clicked");
		}

		//alertDialog.show();
	}
}
//	@Override
//	public void stop() throws Exception {
//		System.out.println("Stop");
//		super.stop();
//	}

