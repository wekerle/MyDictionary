/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Ronaldo
 */
public class WordViewModel extends HBox{
    private WordModel word;

    public WordViewModel(WordModel word) {
        this.word=word;
        this.populateContent();
    }
    
    private void populateContent(){
        Text wordText=new Text(Integer.toString(13));
        wordText.setFont(Font.font("TimesNewRoman",FontWeight.BOLD,20));
        Text echivalentWordText=new Text(Integer.toString(13));
        echivalentWordText.setFont(Font.font("TimesNewRoman",FontWeight.BOLD,20));
        this.setSpacing(25);
       // this.setVgap(25);
        
       this.getStyleClass().add("minimalLevelView");              
        this.getChildren().add(wordText); 
        this.getChildren().add(echivalentWordText);
    }
}
