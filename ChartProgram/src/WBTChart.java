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
        wbt.drawString(firstName, (xRect + (rectWidth/2) - xString) + 5, 65);
        wbt.setColor(Color.blue);
        WBTItem firstWBTItem = new WBTItem(firstName, (xRect + (rectWidth / 2)), 
                70, rectWidth);
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
        int y = prevWBTItem.y + 40; 
        int rectWidth = firstName.length() * 8;
        xRect = prevWBTItem.x - ((100) + rectWidth);
        boolean coll;
        boolean completeCheck = false;
        WBTItem checkItem;
        do{
        coll = false;
        completeCheck = false;
        for (int i = 0; i < itemList.size(); i ++){
            checkItem = itemList.get(i);
            if (checkItem.x - (checkItem.xWidth / 2) <= xRect){
                if (xRect <= (checkItem.x + (checkItem.xWidth / 2))){
                        xRect = xRect + (100 / prevWBTItem.level + 1) + rectWidth;
                        coll = true;
                }
            }
            if (checkItem.x - (checkItem.xWidth / 2) >= xRect){
                if (xRect >= (checkItem.x + (checkItem.xWidth / 2))){
                        xRect = xRect + (100  / prevWBTItem.level + 1) + rectWidth;
                        coll = true;
                }
            if (checkItem.x - (checkItem.xWidth / 2) <= xRect + rectWidth){
                if (xRect + rectWidth <= (checkItem.x + (checkItem.xWidth / 2))){
                        xRect = xRect + (100  / prevWBTItem.level + 1) + rectWidth;
                        coll = true;
                }
            }
            if (checkItem.x - (checkItem.xWidth / 2) >= xRect + rectWidth){
                if (xRect + rectWidth >= (checkItem.x + (checkItem.xWidth / 2))){
                        xRect = xRect + (100  / prevWBTItem.level + 1) + rectWidth;
                        coll = true;
                }
            }
            if (xRect < 10) {
                xRect = xRect + (100  / prevWBTItem.level + 1) + rectWidth;
            }
            }
        }
        if (coll == false) {
            completeCheck = true;
        }
        } while (completeCheck == false);
        wbt.drawRect( xRect, y, rectWidth, 20);
        int xString = (firstName.length() / 2) * 8;
        wbt.drawString(firstName, (xRect + (rectWidth/2) - xString) + 5, (y + 15));
        wbt.drawLine(prevWBTItem.x, prevWBTItem.y, xRect + rectWidth / 2, y);
        
        
        WBTItem newWBTItem = new WBTItem(firstName, (prevWBTItem.level + 1),
                (xRect + (rectWidth / 2)), y + 20, rectWidth);
        itemList.add(newWBTItem);
        noOfItems = noOfItems + 1;
        return wbt;
    }
}

