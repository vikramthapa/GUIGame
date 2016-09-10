/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author anmol
 */
public class Screen extends JPanel{
    Ball football;
    Ball tennisball;
    Bat bat,bat2,bat3;
    public Screen()
    {
        bat = new Bat(200,330);
        bat2 = new Bat(100,100);
        bat3 = new Bat(400,250);
        
        football = new Ball(100,60,10);
        tennisball = new Ball(200,200,20);
        this.setPreferredSize(new Dimension(600,350));
        this.setBackground(Color.gray);
    }
    
    @Override
    public void paint(Graphics g)
    {
        render(g);
    }
    public void render(Graphics g)
    {
        super.paint(g);
        tennisball.paint(g);        
        football.paint(g);
        bat.paint(g);
        bat2.paint(g);
        bat3.paint(g);
    }
    public void play()
    {   while(true)
        {  try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
           tennisball.move();
           football.move();
           
           if(tennisball.intersects(football.getArea()))tennisball.toggle();
           if(football.intersects(tennisball.getArea()))football.toggle();
           
           if(tennisball.intersects(bat.getArea()))tennisball.toggle();
           if(football.intersects(bat2.getArea()))football.toggle();
           if(tennisball.intersects(bat2.getArea()))tennisball.toggle();
           if(football.intersects(bat3.getArea()))football.toggle();
           if(football.intersects(bat3.getArea()))football.toggle();
           
           this.repaint();
        }
    }

    
    
}
