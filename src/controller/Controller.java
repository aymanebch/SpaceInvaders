package controller;

import models.Game;
import models.Fire;
import models.Player;
import util.observer.Observable;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Controller extends Observable {

    /*private Player player;
    private Fire fire; */
    public String RightOrLeft = "TUI" ;
    Scanner myScanner = new Scanner(System.in);

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game game;


    public Controller(Game game) {
        this.game = game;

    }

    public String getRightOrLeft() {
        return this.RightOrLeft;
    }

    public String getGameString() {
        return this.game.toString();
    }

   /* public void movePlayerLeft() {
        this.game.getFire().setPlayepositionX(-1);

    }

    public void movePlayerRight() {
        this.game.getFire().setPlayepositionX(+1);
    }

    public void shoot() {

        this.game.getFire();
    }  */

   /* public void play1 () {
        movePlayer();
    }

    public void play2 () {
        playerShoot(true);
        moveFire();
    }*/

    public void moveFire() {

        this.game.getFire().setFireY(this.game.getFire().getFireY() - 1);

        this.monsterKill();
        /*if (this.fire.getFireY() == -1) {
            this.fire.setFireXY(this.player.getX(), this.game.getHeight() - 2);
        }*/
    }

    public void movePlayer() {

        if (!this.game.getPlayer().isShoot()) {
             if(this.RightOrLeft == "TUI") { this.RightOrLeft = myScanner.next();

            switch (this.RightOrLeft) {
                case "R":
                    this.movePlayerRight();
                    this.RightOrLeft = "TUI";
                    break;
                case "L":
                    this.movePlayerLeft();
                    this.RightOrLeft = "TUI";
                    break;
                case "S":
                    this.Shoot();
                    this.RightOrLeft = "TUI";
                    break;
                case "GUI": break;


               }
             }

             else {

                 switch (this.RightOrLeft) {
                     case "R":
                         this.movePlayerRight();

                         this.RightOrLeft = "GUI";
                         break;
                     case "L":
                         this.movePlayerLeft();

                         this.RightOrLeft = "GUI";
                         break;
                     case "S":
                         this.Shoot();
                         this.RightOrLeft = "GUI";
                         break;

                 }

             }

        } else if (this.game.getPlayer().isShoot()) {
            moveFire();

        }


/*

        if (this.game.getPlayer().isShoot()) {

            if (this.game.getPlayer().getX() < 6) {
                this.game.getPlayer().setX(this.game.getPlayer().getX()+1);
            }

        } else {
            if (this.game.getPlayer().getX() < 6) {
                this.game.getPlayer().setX(this.game.getPlayer().getX()-1);
                this.fire.setFireX(this.player.getX());
            }

        }
*/

    }

    /*public void playerShoot(boolean shoot) {
        this.player.setShoot(shoot);
    }*/


    public void monsterKill() {
        for (int i = 0; i < this.game.getHeight(); i++) {
            for (int j = 0; j < this.game.getWidth(); j++) {

                if (i < this.game.getHeight() / 2 && (this.game.getFire().getFireX() == j) && (this.game.getFire().getFireY() == i) && this.game.getMunster(i, j).islife()) {

                    this.game.getMunster(i, j).setlife(false);
                    this.game.getPlayer().setShoot(false);
                    this.game.getFire().setFireXY(this.game.getPlayer().getX(), this.game.getHeight() - 2);
                    notifyObservers();
                }
            }
        }
    }

    public String getGameElements (int i, int j){
        return this.game.getElementStr(i,j);
    }

    public void movePlayerLeft(){
        if (!this.game.getPlayer().isShoot()) {

                    this.game.getPlayer().setX(this.game.getPlayer().getX() - 1);
                    this.game.getFire().setFireX(this.game.getFire().getFireX() - 1);

        } else if (this.game.getPlayer().isShoot()) {
            moveFire();
        }
    }

    public void movePlayerRight(){
        if (!this.game.getPlayer().isShoot()) {

                    this.game.getPlayer().setX(this.game.getPlayer().getX() + 1);
                    this.game.getFire().setFireX(this.game.getFire().getFireX() + 1);

            }
         else if (this.game.getPlayer().isShoot()) {
            moveFire();
        }
    }

    public void Shoot(){
        this.game.getPlayer().setShoot(true);

    }

    public void run(boolean isOver) {
       // int n = 0;
        while (!isOver) {
            notifyObservers();

            try {
                TimeUnit.MILLISECONDS.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          //  n++;

            this.movePlayer();



        }
    }

    public void actionHandler(String button){
        this.RightOrLeft = button;

        /*switch (RightOrLeft) {
            case "R":
                this.movePlayerRight();
                notifyObservers();
                RightOrLeft = "N";
                break;
            case "L":
                this.movePlayerLeft();
                notifyObservers();
                RightOrLeft = "N";
                break;
            case "S":
                this.Shoot();
                break;

        }*/
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }
}