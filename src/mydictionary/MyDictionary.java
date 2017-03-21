/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary;

import java.io.File;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Ronaldo
 */
public class MyDictionary extends Application{

    private BorderPane borderPane = new BorderPane();
    private Scene scene=new Scene(borderPane);
    private Stage stage=null;
    
    /**
     * @param args the command line arguments
     */        
    public static void main(String[] args)throws Exception 
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        MenuBar menuBar=createMenu();       
        borderPane.setTop(menuBar);  
        borderPane.setCenter(getContent());
        stage=primaryStage;
    
        scene.getStylesheets().add("Styling/styles.css");
                                                     
        primaryStage.setWidth(850);
        primaryStage.setHeight(680);
        
        primaryStage.setTitle("My dictionary");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private GridPane getContent() 
    {
        GridPane grid = new GridPane();   
        
        
        
        grid.setHgap(25);
        grid.setVgap(25);
        grid.setPadding(new Insets(20, 10, 10, 50));
        return grid;
    }
    
    
    private MenuBar createMenu()
    { 
        MenuBar menuBar = new MenuBar();
 
        // --- Menu File
        Menu menuFile = new Menu("Menu");
        
        MenuItem loadMenuItem = new MenuItem("Load");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(actionEvent ->
                stage.fireEvent(
                        new WindowEvent(
                                stage,
                                WindowEvent.WINDOW_CLOSE_REQUEST
                        )
                ));

        menuFile.getItems().addAll(loadMenuItem,
        new SeparatorMenuItem(), exitMenuItem);
        loadMenuItem.setOnAction(actionEvent -> clickLoad());                     
        menuBar.getMenus().addAll(menuFile);
                  
        return menuBar;

    }
    
    private void clickLoad()
    {       
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load Game");

        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("txt", "*.txt")
        );
        File file = fileChooser.showOpenDialog(stage);
        
        if(file!=null)
        {
            //this.aplicationModel=fileToAplicationModel(file.getPath()); 
        } 
        //start(stage);
        WordModel w1=new WordModel(1,"hello1","salut1");
        WordModel w2=new WordModel(2,"hello2","salut2");
        WordModel w3=new WordModel(3,"hello3","salut3");
        WordModel w4=new WordModel(4,"hello4","salut4");
        WordModel w5=new WordModel(5,"hello5","salut5");
        
        ArrayList<WordModel> words=new ArrayList<WordModel>();
        words.add(w5);
        words.add(w4);
        words.add(w3);
        words.add(w2);
        words.add(w1);
        
        DictionaryView dw=new DictionaryView(words);
        borderPane.setCenter(dw);
    }
}
