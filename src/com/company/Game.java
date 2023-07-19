package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public List<Player> playerList = new ArrayList<>();
    public boolean gameEnded = false;

    public void addNewPlayer(String playerName){
        Player player = new Player(playerName);
        player.addDeathEventListener((name) -> {
            System.out.println("player " + name  +" has been killed ");
            removePlayer(player);
        } );

        playerList.add(player);

    }

    public void initialize(int playersNumber){

        Scanner scanner = new Scanner(System.in);
        String name ;

        for (int i = 0; i < playersNumber; i++) {
            System.out.println("enter a name for player number " + (i+1));
            name = scanner.nextLine();
            addNewPlayer(name);

        }


    }

    public void play(){
        int force ;

        if (playerList.size() < 2){
            System.out.println("there are not enough players to play this game !");
            return;
        }

        while (! gameEnded){

            for (Player player : new ArrayList<>(playerList)) {

                System.out.println(player.name + "'s turn now ! ");

                for (Player player2: new ArrayList<>(playerList)) {

                    if(!player.equals(player2)){
                        force = (int) Math.round(Math.random()  *  10 );
                        player.hit(player2,force);
                    }

                }

            }


        }


    }

    public void removePlayer(Player player){
        playerList.remove(player);
        if (playerList.size() == 1){
            endTheGame();
        }

    }

    public void endTheGame(){
        gameEnded = true;
        System.out.println("congratulations ! " + playerList.remove(0).name + " looks like you're the winner !");
    }




}
