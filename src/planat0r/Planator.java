/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planat0r;

import gui.WelcomeJFrame;

/**
 *
 * @author ima3k
 */
public class Planator {
    
    public static String nickname;   
    public static IEngine engine;

    public Planator() {
        engine = new Engine();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomeJFrame().setVisible(true);
            }
        });
    }
    
    
    
    public static void main(String[] args) {
        
        Planator planator = new Planator();
        
    }
    
}
