package com.jamith.javafxspringboot;

import javafx.application.Preloader;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class JavafxSpringBootApplication extends AbstractJavaFxApplicationSupport{

    @Autowired
    private FXMLLoaderBuilder fxmlLoaderBuilder;

    @Value("${spring.application.name}")
    private String appTitle;

    @Override
    public void start(Stage primaryStage) throws Exception {

        notifyPreloader(new AppPreloader.StateChangeNotification(Preloader.StateChangeNotification.Type.BEFORE_START));
        primaryStage.setTitle(appTitle);
        fxmlLoaderBuilder.buildScene(primaryStage,"/com/jamith/javafxspringboot/view/Demo.fxml");
    }

    public static void main(String[] args) {
        launchApp(JavafxSpringBootApplication.class, args);
    }

}
