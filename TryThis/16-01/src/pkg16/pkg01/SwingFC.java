package pkg16.pkg01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Try This 16-1
 * 
 * A Swing-based file comparison utility.
 * 
 */

public class SwingFC implements ActionListener {

    /** Text field for  the first file name. */
    JTextField jtfFirst;
    
    /** Text field for the second file name. */
    JTextField jtfSecond;
    
    /** Label for jtfFirst. */
    JLabel jlabFirst;
    
    /** Label for jtfSecond. */
    JLabel jlabSecond;
    
    /** Label used to display results and error messages. */
    JLabel jlabResult;
    
    /** Constructs a swing based window application of type SwingFc. */
    SwingFC() {
        JFrame jfrm = new JFrame("Compare Files");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(200, 190);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jtfFirst = new JTextField(14);
        jtfSecond = new JTextField(14);
        jtfFirst.setActionCommand("fileA");
        jtfSecond.setActionCommand("fileB");
        JButton jbtnComp = new JButton("Compare");
        jbtnComp.addActionListener(this);
        jlabFirst = new JLabel("First file: ");
        jlabSecond = new JLabel("Second file: ");
        jlabResult = new JLabel("");
        
        // Add components to the frame.
        jfrm.add(jlabFirst);
        jfrm.add(jtfFirst);
        jfrm.add(jlabSecond);
        jfrm.add(jtfSecond);
        jfrm.add(jbtnComp);
        jfrm.add(jlabResult);
         
        // Display the frame.
        jfrm.setVisible(true);
    }
    
    // Compare the files when the Compare button is pressed.
    public void actionPerformed(ActionEvent ae) {
        int i=0, j=0;
        
        if(jtfFirst.getText().equals("")) {
            jlabResult.setText("First file name is missing.");
            return;
        }
        if(jtfSecond.getText().equals("")) {
            jlabResult.setText("Second file name is missing.");
            return;
        }
        
        try (FileInputStream f1 = new FileInputStream(jtfFirst.getText());
                FileInputStream f2 = new FileInputStream(jtfSecond.getText()))
        {
            // Check the content of each file.
            do {
                i = f1.read();
                j = f2.read();
                if(i != j) break;
            } while(i != -1 && j != -1);
            if(i != j)
                jlabResult.setText("File content is not equal.");
            else
                jlabResult.setText("File content is equal.");
        } catch(IOException exc) {
            jlabResult.setText("File Error");
        }
    }
    
    public static void main(String args[]) {
        // Create the frame and run it on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingFC();
            }
        });
    }
}
