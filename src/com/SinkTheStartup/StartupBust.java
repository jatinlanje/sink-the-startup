package com.SinkTheStartup;

import java.util.ArrayList;

public class StartupBust {

    private GameHelper helper = new GameHelper(); //instantiate GameHelper instance variable, name helper
    private ArrayList<Startup> startups = new ArrayList<Startup>(); //to hold list of startups
    private int numOfGuesses = 0; //(so that we can give the user a score at the end of the game)

    private void setUpGame() {
        // first make some Startups and give them locations
        Startup one = new Startup(); //Startup object
        one.setName("poniez"); //set a name
        Startup two = new Startup();
        two.setName("hacqi");
        Startup three = new Startup();
        three.setName("cabista");
        startups.add(one); //add Startup to startups(ArrayList)
        startups.add(two);
        startups.add(three);

        //brief instructions for user
        System.out.println("Your goal is to sink three Startups.");
        System.out.println("poniez, hacqi, cabista");
        System.out.println("Try to sink them all in the fewest number of guesses");

        for (Startup startup : startups) { //repeat with each of the Startup objects in the startups List
            ArrayList<String> newLocation = helper.placeStartup(3); //ask the helper for a Startup location (an ArrayList of Strings)
            startup.setLocationCells(newLocation); //call the setter method on this Startup to give it the location you just got from the helper
        } // close for loop
    } // close setUpGame method

    private void startPlaying() {
        while (!startups.isEmpty()) { //repeat while any Startup exist
            String userGuess = helper.getUserInput("Enter a guess"); //get user input
            checkUserGuess(userGuess); //call our own checkUserGuess method
        } // close while
        finishGame(); //call our own finishGame method
    } // close startPlaying method

    private void checkUserGuess(String userGuess) { //find out if there's a hit (and kill) on any Startup
        numOfGuesses++; //increment the number of guesses the user has made
        String result = "miss"; // assume a miss until told otherwise

        for (Startup startupToTest : startups) { //for each Startup object in the startups List
            result = startupToTest.checkYourself(userGuess); //evaluate ask the Startup to check the user guess, looking for a hit (or kill)

            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                startups.remove(startupToTest); //This one's dead, so remove the Startup from the startups List
                break;
            }
        } // close for

        System.out.println(result); //print result for user
    } // close method

    //tell user how they did in the game
    private void finishGame() {
        System.out.println("All Startups are dead! Your stock is now worthless");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    } // close method

    public static void main(String[] args) {
        StartupBust game = new StartupBust(); //create game object
        game.setUpGame(); //tell the game object to set up the game
        game.startPlaying(); //tell the game object to start the main game paly loop (keep asking for user input and checking the guess)
    } // close method
}

