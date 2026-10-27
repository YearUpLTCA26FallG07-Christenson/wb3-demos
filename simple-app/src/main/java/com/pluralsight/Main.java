package com.pluralsight;

public class Main {

    public static void main (String[] args){

        Dice dice = new Dice();



        //Asked how many players there are...



            int numberOfPlayers = -1 ;
            numberOfPlayers = Console.promptForInt("How many players are there? ");




            // Ask the name of each player:

            String[] playerNames = new String[numberOfPlayers];

            for( int playerNumber = 1; playerNumber <= numberOfPlayers; playerNumber++){
                int playerIndex = playerNumber - 1;
                playerNames[playerIndex] = Console.promptForString("What is the name of player " + playerNumber + ": ");

            }

            //Each player should roll
            int[] rolls = new int[numberOfPlayers];


            for( int playerNumber = 1; playerNumber <= numberOfPlayers; playerNumber++){
                int playerIndex = playerNumber - 1;
                rolls[playerIndex] = dice.roll();
                System.out.printf("%s rolled a %d\n", playerNames[playerIndex], rolls[playerIndex]);
            }

            //----------------
            // what is the highest roll.

            int highestRoll = rolls[0];
            for(int roll : rolls){
                if( roll > highestRoll){
                    highestRoll = roll;
                }
            }

            //----------------
            // how many are there of the highest roll?

            int numberOfHighestRolls = 0;
            for(int roll : rolls){
                if(roll == highestRoll){
                    numberOfHighestRolls++;
                }
            }

            // is there a tie?
            boolean isTie = (numberOfHighestRolls > 1);

            if(isTie){
                //is a tie.
                System.out.print("It's a tie between ");
                int printedNameCounter = 0;

                for( int playerNumber = 1; playerNumber <= numberOfPlayers; playerNumber++){
                    int playerIndex = playerNumber - 1;
                    if(rolls[playerIndex] == highestRoll){

                        System.out.print(playerNames[playerIndex]);
                        printedNameCounter++;

                        //are they the last name?
                        if(printedNameCounter == numberOfHighestRolls){
                            System.out.println(".");
                        }
                        else{
                            System.out.print(", ");
                        }


                    }

                }


            }
            else{
                //not a tie.
                int indexOfSingleWinner;
                for( int playerNumber = 1; playerNumber <= numberOfPlayers; playerNumber++){
                    int playerIndex = playerNumber - 1;
                    if(rolls[playerIndex] == highestRoll){
                        System.out.println(playerNames[playerIndex] + " Wins!");
                    }

                }

            }


    }
}
