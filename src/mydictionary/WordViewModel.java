/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary;

import Listener.MarkWordListener;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private MarkWordListener markWordListener;

    public WordViewModel(WordModel word, MarkWordListener markWordListener) {
        this.word=word;
        this.markWordListener = markWordListener;
        this.populateContent();
    }
    
    private void populateContent(){
        Image imageStarGray = new Image("/img/starGray.png");
        Image imageStarOrange = new Image("/img/starOrange.png");
        ImageView imageViewStar = new ImageView(imageStarGray);
        
        imageViewStar.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if(!WordViewModel.this.word.getIsMarked()){
                    imageViewStar.setImage(imageStarOrange);
                    WordViewModel.this.word.setIsMarked(true);
                }else{
                    imageViewStar.setImage(imageStarGray);
                    WordViewModel.this.word.setIsMarked(false);
                }
                WordViewModel.this.markWordListener.addMarked(WordViewModel.this.word);              
            }
        });
        
        Text wordText=new Text(this.word.getFirstLanguageWorld());
        wordText.setFont(Font.font("TimesNewRoman",FontWeight.BOLD,20));
        Text echivalentWordText=new Text(this.word.getEchivalentWorld());
        echivalentWordText.setFont(Font.font("TimesNewRoman",FontWeight.BOLD,20));    
        
        wordText.setStyle("-fx-cursor: hand;");
        echivalentWordText.setStyle("-fx-cursor: hand;");
        imageViewStar.setStyle("-fx-cursor: hand;");
        
        this.setSpacing(25);         
        this.getStyleClass().add("word");  
        this.getChildren().add(imageViewStar);
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
