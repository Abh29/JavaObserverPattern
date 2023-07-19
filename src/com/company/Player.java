package com.company;


import java.util.ArrayList;
import java.util.List;


/**
 * Implement a game model – players consistently hit each other with a force from 1 to 9, while the one who was
 * hit is taken away from the health points (hp). The game ends when the hp of one of the players has become <= 0.
 * The task must have the Player and Game classes in which the entire process takes place. Each player has a name and hp.
 * The impact force of each player at each step is entered from the console. The game process must belong to an object of
 * the Game class.
 * Add a probability distribution – the impact force is inversely proportional to the probability of being hit.
 * */
public class Player {

    public int hp = 100;
    public String name;
    public List<DeathEvent> listeners;
    public boolean dead;

    public Player(String name) {
        this.name = name;
        listeners = new ArrayList<>();
        dead = false;
    }

    public void takeDamage(int penalty) {

        System.out.println("player " + name + " is hit !");

        hp -= penalty;
        if (hp <= 0) {
            dead = true;
            fireDeathEvent();
        }
    }

    public void hit(Player player, int force) {
        if (force > 9 || force < 1)
            return;

        int penalty = (int) Math.round(force * Math.random());
        player.takeDamage(penalty);


    }

    public void fireDeathEvent() {

        for (DeathEvent listener : listeners) {
            listener.killed(name);
        }
    }

    public void addDeathEventListener(DeathEvent listener) {
        listeners.add(listener);
    }


}
