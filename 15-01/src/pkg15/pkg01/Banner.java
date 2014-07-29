package pkg15.pkg01;


import java.applet.Applet;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simple banner applet.
 *
 * This applet creates a thread that scrolls the message contained in msg right
 * to left across the applet's window.
 */
/*
 <applet code = "Banner" width = 300 height = 50>
 </applet>
 */
public class Banner extends Applet implements Runnable {

    String msg = " Java Rules the Web ";
    Thread t;
    boolean stopFlag;

    // Initialize t to null.
    public void init() {
        t = null;
    }

    // Start thread
    public void start() {
        t = new Thread(this);
        stopFlag = false;
        t.start();
    }

    // Entry point for the thread that runs the banner.
    @Override
    public void run() {
        // Redisplay banner
        for (;;) {
            try {
                repaint();
                Thread.sleep(250);
                if (stopFlag) {
                    break;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Banner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // Pause the banner;
    public void stop() {
        stopFlag = true;
        t = null;
    }
    
    // Display the banner.
    public void paint(Graphics g) {
        char ch;
        
        ch = msg.charAt(0);
        msg = msg.substring(1, msg.length());
        msg += ch;
        g.drawString(msg, 50, 30);
    }
    
}
