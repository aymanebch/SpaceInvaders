package view;
import controller.Controller;
import util.observer.IObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Gui extends JFrame implements IObserver {
    Controller controller;
    guiElement[][] guiGrid;
    int width;
    int height;
    JPanel panelGame;
    JPanel commandes;
    JButton moveLeft;
    JButton moveRight;
    JButton Shoot;
    JButton TUI;

    public Gui(Controller controller) {
        this.controller = controller;
        this.width = this.controller.getGame().getWidth();
        this.height = this.controller.getGame().getHeight();
        this.guiGrid = new guiElement[height][width];

        panelGame = new JPanel();
        panelGame.setLayout(new GridLayout(height,width, 0, 0));
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.guiGrid[i][j] = new guiElement(controller.getGameElements(i,j), i, j);
                panelGame.add(this.guiGrid[i][j]);

            }
        }
        panelGame.setVisible(true);

        commandes = new JPanel();
        commandes.setLayout(new GridLayout(1,4, 3, 3));
        moveLeft = new JButton("Left");
        moveLeft.setVisible(true);
        moveLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.actionHandler("L");
            }
        });

        Shoot = new JButton("Shoot");
        Shoot.setVisible(true);
        Shoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.actionHandler("S");


            }
        });

        moveRight = new JButton("Right");
        moveRight.setVisible(true);
        moveRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.actionHandler("R");
            }
        });

        TUI = new JButton("TUI");
        TUI.setVisible(true);
        TUI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.actionHandler("TUI");
            }
        });

        commandes.add(moveLeft);
        commandes.add(Shoot);
        commandes.add(moveRight);
        commandes.add(TUI);
        commandes.setVisible(true);

        JPanel container = new JPanel();

        container.add(panelGame);
        container.add(commandes);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setTitle("Space Invaders");
        this.getContentPane().add(container); // Adds Button to content pane of frame
        this.setVisible(true);
    }

    public void update(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.guiGrid[i][j].setValue(controller.getGameElements(i,j));

            }
        }



    }

}





