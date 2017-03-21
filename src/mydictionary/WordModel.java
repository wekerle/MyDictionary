/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary;

/**
 *
 * @author Ronaldo
 */
public class WordModel {
    private int id;
    private String firstLanguageWorld;
    private String echivalentWorld;

    public int getId() {
        return id;
    }

    public String getFirstLanguageWorld() {
        return firstLanguageWorld;
    }

    public String getEchivalentWorld() {
        return echivalentWorld;
    }

    public WordModel(int id, String firstLanguageWorld, String echivalentWorld) {
        this.id = id;
        this.firstLanguageWorld = firstLanguageWorld;
        this.echivalentWorld = echivalentWorld;
    }
}
