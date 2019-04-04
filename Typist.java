/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvctypingtest;

public class Typist {//Stove
    
    private String nickname;
    private int wpm;
    
    public Typist(){
        nickname = "default";
        wpm = 0;
    }
    
    public Typist(String n, int w){
        nickname = n;
        wpm = w;
    }
    
    String getNick(){
        return nickname;
    }
    
    void setNick(String n){
        nickname = n;
    }
    
    int getWPM(){
        return wpm;
    }
    
    void setWPM(int w){
        wpm = w;
    }
}
