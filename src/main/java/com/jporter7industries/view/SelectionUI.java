package com.jporter7industries.view;

import com.jporter7industries.model.entities.Language;
import com.jporter7industries.model.services.CodeSnippetRepository;
import com.jporter7industries.model.services.LanguageRepository;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by jeffryporter on 8/29/16.
 */
@Controller
public class SelectionUI implements EventHandler<ActionEvent>
{
    private Stage selectionStage;
    private ComboBox language;
    private TextField tags;
    private TextField keywords;
    private TextArea code;

    @Autowired
    CodeSnippetRepository snippets;

    @Autowired
    LanguageRepository languages;


    public void init() throws SQLException, IOException
    {
        //for H2 builds ONLY!!!!!!*****************************//
        Server.createWebServer("-webPort", "39071").start();    //
        //for H2 builds ONLY!!!!!!*****************************//
        if (languages == null)
        {
            addLanguages();
        }
    }


    public class searchBtnHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {


        }
    }

    public class addSnippetHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {

        }
    }

    public class addLanguageHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent event)
        {

        }
    }



    public SelectionUI(Stage stage) throws IOException, SQLException
    {
        init();
        selectionStage = stage;
        GridPane pane = new GridPane();
        GridPane topInsertPane = new GridPane();
        GridPane bottomInsertPane = new GridPane();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        selectionStage.setTitle("Code Snippets");
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setPadding(new Insets(10,10,10,10));
        topInsertPane.setHgap(5);
        topInsertPane.setVgap(5);
        topInsertPane.setPadding(new Insets(10,10,10,10));
        bottomInsertPane.setHgap(5);
        bottomInsertPane.setVgap(5);
        bottomInsertPane.setPadding(new Insets(10,10,10,10));

        //TOP INSERT PANE START
        Label lbl = new Label("Language:");
        ArrayList<Language> langList = (ArrayList<Language>)languages;
        ArrayList<String> langStringList = new ArrayList<>();
        language = new ComboBox();
        if (langList.isEmpty())
        {
            for (Language l : langList)
            {
                langStringList.add(l.getLanguage());
            }
            language.setItems((ObservableList) langStringList);
        }

        Button langPlusBtn = new Button("+");
        topInsertPane.add(lbl, 0, 1);
        topInsertPane.add(language, 1, 1);
        topInsertPane.add(langPlusBtn,2,1);

        lbl = new Label("Tags:");
        tags = new TextField();
        topInsertPane.add(lbl, 0, 2);
        topInsertPane.add(tags, 1, 2);

        lbl = new Label("Keywords:");
        keywords = new TextField();
        topInsertPane.add(lbl, 0, 3);
        topInsertPane.add(keywords, 1, 3);
        //TOP INSERT PANE END

        pane.add(topInsertPane, 0,1);

        lbl = new Label("Code:");
        code = new TextArea();
        pane.add(lbl, 0, 2);
        pane.add(code, 0, 3);

        Button searchBtn = new Button("Search");
        Button addBtn = new Button("Add");
        Button closeBtn = new Button("Close");
        pane.add(searchBtn, 0, 0);
        bottomInsertPane.add(addBtn, 0, 0);
        bottomInsertPane.add(closeBtn, 1, 0);

        pane.add(bottomInsertPane, 0,4);

        searchBtn.setOnAction(new searchBtnHandler());
        addBtn.setOnAction(new addSnippetHandler());
        langPlusBtn.setOnAction(new addLanguageHandler());
        closeBtn.setOnAction(this);

    }

    public void show()
    {
        selectionStage.show();
    }

    @Override
    public void handle(ActionEvent event)
    {
        selectionStage.close();
    }

    public void addLanguages()
    {
        String[] langList = {"java", "javascript", "php", "c", "c++", "c#", "angular.js", "node.js", "android studio",
                "sql", "clojure", "python", "ruby", "react.js", "springMVC", "hibernate"};
        for(String l: langList)
        {
            Language newLang = new Language(l);
            languages.save(newLang);
        }

    }
}
