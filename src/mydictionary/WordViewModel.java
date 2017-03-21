/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
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
        Text wordText=new Text(this.word.getFirstLanguageWorld());
        wordText.setFont(Font.font("TimesNewRoman",FontWeight.BOLD,20));
        Text echivalentWordText=new Text(this.word.getEchivalentWorld());
        echivalentWordText.setFont(Font.font("TimesNewRoman",FontWeight.BOLD,20));
        this.setSpacing(25);
         
        this.getStyleClass().add("word");              
        this.getChildren().add(wordText); 
        this.getChildren().add(echivalentWordText);
        echivalentWordText.setVisible(false);
        
        wordText.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                echivalentWordText.setVisible(true);
            }
        });    
    }
}
