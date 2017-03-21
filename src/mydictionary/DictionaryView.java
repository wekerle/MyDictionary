/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary;

import java.util.ArrayList;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Ronaldo
 */
public class DictionaryView extends VBox{
    private GridPane grid=new GridPane();
    private ArrayList<WordModel> words;

    public DictionaryView(ArrayList<WordModel> words) {
        this.words=words;
        this.populateContent();
    }
    
    private void populateContent(){
        for(WordModel world:this.words)
        {
            //Text wordText=new Text(Integer.toString(13));
            //wordText.setFont(Font.font("TimesNewRoman",FontWeight.BOLD,40));  
            //this.getStyleClass().add("minimalLevelView"); 
            this.grid.getChildren().add(new WordViewModel(world));
            this.getChildren().add(new WordViewModel(world));
            
        }
       // this.getChildren().add(grid);
        //grid.set
         grid.setVgap(25);
         grid.setHgap(25);
         this.getStyleClass().add("test"); 
        this.setSpacing(10);
    }
}
