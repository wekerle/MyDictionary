/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Ronaldo
 */
public class DictionaryView extends VBox{
    private ArrayList<PageView> pages;
    private ArrayList<WordModel> words;
    private int currentPage=1;
    private int maxPage=1;
    private VBox pageConainer=new VBox();
    Text pageIndicator=new Text("Page:1/4");
        
    public DictionaryView(ArrayList<WordModel> words) {
        this.words=words;
        this.populateContent();
    }
    
    private void populateContent(){
        this.getChildren().add(pageConainer);
        this.drawPages();
        HBox footerNode=new HBox();
        
        Image imageNext=new Image("/img/next.png");
        Button buttonNext=new Button("Next Page", new ImageView(imageNext));

        buttonNext.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) {
                DictionaryView.this.currentPage++;
                if(DictionaryView.this.currentPage<=DictionaryView.this.maxPage)
                {
                    DictionaryView.this.renderPage(DictionaryView.this.currentPage);
                }
            }
        });
            
        footerNode.getChildren().add(buttonNext);
               
        Image imageSwitch=new Image("/img/switch.png");
        Button buttonSwitch=new Button("Switch language", new ImageView(imageSwitch));  
        
        buttonSwitch.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) {
                DictionaryView.this.switchLanguage();
            }
        });
        
        footerNode.getChildren().add(buttonSwitch);
        
        Image imageRestart=new Image("/img/restart.png");
        Button buttonRestart=new Button("Restart", new ImageView(imageRestart));  
        
        buttonRestart.setOnMouseClicked(new EventHandler<MouseEvent>()
        {

            @Override
            public void handle(MouseEvent event) {                
                DictionaryView.this.drawPages();
            }
        });
               
        footerNode.getChildren().add(buttonRestart);
        pageIndicator.setFont(Font.font("TimesNewRoman",FontWeight.BOLD,20));
        
        footerNode.getChildren().add(pageIndicator);
        footerNode.setAlignment(Pos.CENTER);
        footerNode.setSpacing(20);
        
        this.getChildren().add(footerNode);   
    }
    
    private void renderPage(int pageNr)
    {
        this.pageConainer.getChildren().clear();
        this.pageConainer.getChildren().add(pages.get(pageNr-1)); 
        this.pageIndicator.setText("Page:"+this.currentPage+"/"+this.maxPage);
    }
    
    private void drawPages()
    {
        this.currentPage=1;
        this.maxPage=1;
        int i=0;
        pages=new ArrayList<PageView>();
        long seed = System.nanoTime();
        Collections.shuffle(this.words, new Random(seed));
        
        ArrayList<WordViewModel> wordsPerPage=new ArrayList<WordViewModel>();
        for(WordModel word:this.words)
        {
            i++;
            wordsPerPage.add(new WordViewModel(word));
            if(i==12)
            {
                i=0;
                this.pages.add(new PageView(wordsPerPage));
                wordsPerPage=new ArrayList<WordViewModel>();
                maxPage++;
            } 
        }
        if(i!=0)
        {
            this.pages.add(new PageView(wordsPerPage));
        }    
        
        this.renderPage(currentPage);
    }
    
    private void switchLanguage()
    {
        for(WordModel word:this.words)
        {
            String aux=word.getFirstLanguageWorld();
            word.setFirstLanguageWorld(word.getEchivalentWorld());
            word.setEchivalentWorld(aux);
        }
        this.drawPages();
    }
}
