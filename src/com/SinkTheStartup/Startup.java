package com.SinkTheStartup;

import java.util.ArrayList;

public class Startup {
    private ArrayList<String> locationCells; //cell locations
    private String name; //Startup's name

    public void setLocationCells(ArrayList<String> loc) { //random location provided by the GameHelper placeStartup() method
        locationCells = loc;
    }

    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) { //The ArrayList indexOf() method in action!
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index); //delete an entry
            if (locationCells.isEmpty()) { //to see if all of the locations have been guessed
                result = "kill";
                System.out.println("Ouch! You sunk " + name + "   : ( ");
            } else {
                result = "hit";
            } // end if
        } // end outer if
        return result; //'miss' or 'hit' or 'kill'
    } // end method
} // close class

