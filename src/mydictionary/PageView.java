/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Ronaldo
 */
public class PageView extends VBox{
    public PageView(ArrayList<WordViewModel> words) {
        this.populateContent(words);
    }
    
    private void populateContent(ArrayList<WordViewModel> words){
        for(WordViewModel wordView:words)
        {
            this.getChildren().add(wordView);
        }
        this.getStyleClass().add("page");
        this.setSpacing(10);
    }
}
