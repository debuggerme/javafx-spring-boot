package com.jamith.javafxspringboot;

import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppPreloader extends Preloader {

	private Stage stage;

	@Override
	public void start(Stage primaryStage) {

		this.stage = primaryStage;

		Scene scene = new Scene(new ProgressIndicator(-1), 100, 100);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
       	primaryStage.initStyle(StageStyle.UNDECORATED);

	}

	@Override
	public void handleApplicationNotification(PreloaderNotification pn) {

		if (pn instanceof StateChangeNotification) {
			stage.hide();
		}
	}
}
