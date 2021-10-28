package com.jamith.javafxspringboot;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class FXMLLoaderBuilder extends FXMLLoader {

    @Autowired
    private ApplicationContext applicationContext;

    private double xOffset = 0;
    private double yOffset = 0;

    public FXMLLoaderBuilder(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void buildScene(Stage primaryStage, String resourceLocation) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(resourceLocation));
        loader.setControllerFactory(applicationContext::getBean);
        Parent parent = loader.load();
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/logo.png"))));

        parent.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        parent.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

        Scene scene=new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.getScene().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/jamith/javafxspringboot/css/Home.css")).toExternalForm());
        primaryStage.show();
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
    }


    public Parent buildSceneForPane(String resourceLocation) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(resourceLocation));
        loader.setControllerFactory(applicationContext::getBean);
        return loader.load();
    }



    public Parent buildSceneForPane(String resourceLocation, ParameterPass parameterPass, ParameterController parameterController) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(resourceLocation));
        loader.setControllerFactory(applicationContext::getBean);
        Parent parent= loader.load();
        loader.<ParameterController>getController().receiveData(parameterPass,parameterController);
        return parent;
    }
}
