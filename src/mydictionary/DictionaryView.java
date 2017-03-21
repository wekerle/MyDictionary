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
    private ArrayList<PageView> pages=new ArrayList<PageView>();
    private ArrayList<WordModel> words;

    public DictionaryView(ArrayList<WordModel> words) {
        this.words=words;
        this.populateContent();
    }
    
    private void populateContent(){
        int i=0;
        ArrayList<WordViewModel> wordsPerPage=new ArrayList<WordViewModel>();
        for(WordModel world:this.words)
        {
            i++;
            wordsPerPage.add(new WordViewModel(world));
            if(i==12)
            {
                i=0;
                this.pages.add(new PageView(wordsPerPage));
                wordsPerPage=new ArrayList<WordViewModel>();
            } 
        }
        if(i!=0)
        {
            this.pages.add(new PageView(wordsPerPage));
        }
        
        this.getChildren().add(pages.get(0));      
    }
}
