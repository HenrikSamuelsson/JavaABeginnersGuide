package swingfilecompare;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Compares the content of two files.
 */
public class SwingFileCompare implements ActionListener {

    /**
     * Text field for the first file name.
     */
    JTextField jtfFirst;

    /**
     * Text field for the second file name.
     */
    JTextField jtfSecond;

    /**
     * Check button for file comparison option setting.
     */
    JCheckBox jcboxOption;

    /**
     * Label for jtfFirst.
     */
    JLabel jlabFirst;

    /**
     * Label for jtfSecond.
     */
    JLabel jlabSecond;

    /**
     * Label for jcboxOption
     */
    JLabel jlabOption;

    /**
     * Label used to display results and error messages.
     */
    JLabel jlabResult;

    /**
     * Constructs a swing based window application of type SwingFc.
     */
    SwingFileCompare() {
        JFrame jfrm = new JFrame("Compare Files");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(220, 220);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jtfFirst = new JTextField(14);
        jtfSecond = new JTextField(14);
        jtfFirst.setActionCommand("fileA");
        jtfSecond.setActionCommand("fileB");
        jcboxOption = new JCheckBox();
        JButton jbtnComp = new JButton("Compare");
        jbtnComp.addActionListener(this);
        jlabFirst = new JLabel("First file: ");
        jlabSecond = new JLabel("Second file: ");
        jlabOption = new JLabel("Show comparison details:");
        jlabResult = new JLabel("");

        // Add components to the frame.
        jfrm.add(jlabFirst);
        jfrm.add(jtfFirst);
        jfrm.add(jlabSecond);
        jfrm.add(jtfSecond);
        jfrm.add(jlabOption);
        jfrm.add(jcboxOption);
        jfrm.add(jbtnComp);
        jfrm.add(jlabResult);

        // Display the frame.
        jfrm.setVisible(true);
    }

    // Compare the files when the Compare button is pressed.
    @Override
    public void actionPerformed(ActionEvent ae) {
        int i = 0, j = 0;

        if (jtfFirst.getText().equals("")) {
            jlabResult.setText("First file name is missing.");
            return;
        }
        if (jtfSecond.getText().equals("")) {
            jlabResult.setText("Second file name is missing.");
            return;
        }

        try (FileInputStream f1 = new FileInputStream(jtfFirst.getText());
                FileInputStream f2 = new FileInputStream(jtfSecond.getText())) {
            int c = 0;
            // Check the content of each file.
            do {
                i = f1.read();
                j = f2.read();
                c++;
                if (i != j) {
                    break;
                }
            } while (i != -1 && j != -1);
            if (i != j) {
                if (jcboxOption.isSelected()) {
                    jlabResult.setText("First difference found at position: " + c);
                } else {
                    jlabResult.setText("File contents are not equal. " );
                }
            } else {
                jlabResult.setText("File contents are equal.");
            }
        } catch (IOException exc) {
            jlabResult.setText("File Error");
        }
    }

    public static void main(String args[]) {
        // Create the frame and run it on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingFileCompare();
            }
        });
    }
}
