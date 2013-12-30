/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inse;

/**
 *
 * @author HP
 */
public abstract class Inputs {
    protected String taskName;
    
    
    

public Inputs () {
}

public Inputs (String tn){
taskName = tn; }


public String getTaskName(){
    return taskName;
}
}


