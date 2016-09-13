/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import component.Screen;
import component.Stage;
import core.Type;
import guigame.GUIGame;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author anmol
 */
public class Game implements KeyListener{
    
    Screen screen;
    Football ball;
    Bat bat;
    /**
     * Game starts from here...
     */
    public Game()
    {
        bat = new Bat(new Point(250,340),100,20,Type.rectangle);
        bat.setColor(Color.RED);
        
        screen = new Screen(600,350,Color.WHITE);
        ball = new Football(new Point(100,100),"ball.png",bat);
        
        screen.add(ball);
        
        screen.add(bat);
        Stage stage = new Stage(screen);
        stage.addKeyListener(this);
        screen.play();
    }
/**
 * This Method is used when any key is Typed
 * @param e 
 */
    @Override
    public void keyTyped(KeyEvent e) {
    System.out.println("Key Typed!!!");
    }

    @Override
    public void keyPressed(KeyEvent e) {
    System.out.println(e.getKeyCode());
    if(e.getKeyCode()==37)
        bat.left();
    if(e.getKeyCode()==39)
        bat.right();
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
    System.out.println("Key Released!!!");
    }
}
