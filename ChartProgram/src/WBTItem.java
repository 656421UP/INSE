/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author up655826
 */
public class WBTItem {
    String name;
    int level, x, y, xWidth;
    
    public WBTItem(String firstName, int newX, int newY, int newXWidth){
        name = firstName;
        level = 1;
        x = newX;
        y = newY;
        xWidth = newXWidth;
    }
    
    public WBTItem(String newName, int newLevel, int newX, int newY,
            int newXWidth){
        name = newName;
        level = newLevel;
        x = newX;
        y = newY;
        xWidth = newXWidth;
    }
    
    public String getName(){
        return name;
    }
}
