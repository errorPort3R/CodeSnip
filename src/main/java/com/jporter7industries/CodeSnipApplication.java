package com.jporter7industries;

import com.jporter7industries.view.SelectionUI;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeSnipApplication extends Application
{
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		SelectionUI ui = new SelectionUI(primaryStage);
		ui.show();
	}

	public static void main(String[] args) {
		SpringApplication.run(CodeSnipApplication.class, args);
		Application.launch(args);
	}

}
