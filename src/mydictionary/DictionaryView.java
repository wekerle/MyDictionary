/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

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
            Text wordText=new Text(Integer.toString(13));
            wordText.setFont(Font.font("TimesNewRoman",FontWeight.BOLD,40));  
            this.getStyleClass().add("minimalLevelView");              
            this.getChildren().add(wordText);
        }       
    }
}
