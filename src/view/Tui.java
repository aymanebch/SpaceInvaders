package view;

import controller.Controller;
import util.observer.IObserver;

import java.util.concurrent.TimeUnit;

public class Tui implements IObserver {
    Controller controller;

    public Tui(Controller controller) {
        this.controller = controller;
    }

    public void printGame() {
        System.out.println(this.controller.getGameString());
    }

   /* public void run(boolean isOver) {
        int n = 0;
        while (!isOver) {
            this.printGame();

            try {
                TimeUnit.MILLISECONDS.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            n++;

            this.controller.movePlayer();
            // this.controller.moveFire();

            /*if (n <= 45) {
                this.controller.play2();
            }

            else if(n == 46) {
                this.controller.play1();

            }

            else if (n >= 45) {
                this.controller.play2();
            }*/
   public void update() {

       this.printGame();
   }

        }


