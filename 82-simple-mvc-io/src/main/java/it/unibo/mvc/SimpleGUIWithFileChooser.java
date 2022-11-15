package it.unibo.mvc;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private static final int PROPORTION =5;

    public SimpleGUIWithFileChooser(){

        SimpleGUI g = new SimpleGUI();

        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        final JTextArea text = new JTextArea();
        text.setText(g.getController().getPath());
        panel2.add(text,BorderLayout.CENTER);
        JButton browse = new JButton("Browse...");
        panel2.add(browse,BorderLayout.EAST);

        browse.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                JFileChooser chooser = new JFileChooser();
                int returnVal = chooser.showOpenDialog(g.getMainPanel());
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " +
                        chooser.getSelectedFile().getName());
                    g.getController().changeFile(chooser.getSelectedFile());
                    text.setText(g.getController().getPath());
                    g.getController().printContent();
                }
                else if (returnVal == JFileChooser.CANCEL_OPTION){

                }
                else {
                    JOptionPane.showMessageDialog(frame,"Error...");
                }
            }
            
        });

        g.getMainPanel().add(panel2,BorderLayout.NORTH);

        frame.setContentPane(g.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    } 

    private void display() {
        /*
         * Make the frame one fifth the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }

    /**
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String... args) {
       new SimpleGUIWithFileChooser().display();
    }

}
