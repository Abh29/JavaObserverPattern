package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Game  newGame = new Game();

        System.out.println("how many players you want to play ? ");
        newGame.initialize(scanner.nextInt());

        newGame.play();


    }
}
