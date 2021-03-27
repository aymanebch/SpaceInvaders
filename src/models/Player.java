package models;

public class Player {
    private int x;
    private boolean shoot;

    public Player(int x, boolean shoot) {
        this.x = x;
        this.shoot = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    /*public void setRight() {
            ++this.x;
        }
        public void setLeft() {
            --this.x;
        }*/
    public boolean isShoot() {
        return this.shoot;
    }

    public void setShoot(boolean shoot) {
        this.shoot = shoot;
    }

    public String toString() {
        return "*";

    }
}