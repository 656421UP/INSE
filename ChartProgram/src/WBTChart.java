/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import java.util.ArrayList;
/**
 *
 * @author up655826
 */
public class WBTChart {

    Graphics drawing;
    ArrayList<WBTItem> itemList = new ArrayList();
    int noOfItems;
    
    public WBTChart() {

    }
    
    public Graphics addFirst(String firstName, Graphics wbt, int width){
        int xRect = width / 2 - 50;
        int rectWidth = firstName.length() * 8;
        wbt.drawRect( xRect, 50, rectWidth, 20);
        int xString = (firstName.length() / 2) * 8;
        wbt.drawString(firstName, (xRect + (rectWidth/2) - xString), 65);
        wbt.setColor(Color.blue);
        WBTItem firstWBTItem = new WBTItem(firstName, (xRect + (rectWidth / 2)), 
                70);
        itemList.add(firstWBTItem);
        return wbt;
    }
    
    public Graphics add(String firstName, Graphics wbt, int width, 
            String linksTo, String side){
        int xRect = 0;
        WBTItem prevWBTItem = null;
        for (int i = 0; i < itemList.size(); i ++){
            if (itemList.get(i).getName().equals(linksTo)){
                prevWBTItem = itemList.get(i);
            }
        }
        int y = (prevWBTItem.level + 5) * 10 + 20; 
        if (side.equals("Left")){
            xRect = prevWBTItem.x - 10;
        } else if (side.equals("Right")){
            xRect = prevWBTItem.x + 10;
        }
        int rectWidth = firstName.length() * 8;
        wbt.drawRect( xRect, y, rectWidth, 20);
        int xString = (firstName.length() / 2) * 8;
        wbt.drawString(firstName, (xRect + (rectWidth/2) - xString), 65);
        wbt.setColor(Color.blue);

        
        
        WBTItem newWBTItem = new WBTItem(firstName, (prevWBTItem.level + 1),
                (xRect + (rectWidth / 2)), 70);
        itemList.add(newWBTItem);
        noOfItems = noOfItems + 1;
        return wbt;
    }
}

