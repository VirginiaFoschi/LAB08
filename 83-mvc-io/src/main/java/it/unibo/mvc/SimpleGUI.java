package it.unibo.mvc;

import javax.swing.*;
import java.util.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 5;
    private Controller c = new SimpleController();

    public SimpleGUI(){

        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTextField field = new JTextField("Text Field");
        JTextArea area = new JTextArea("Text Area");
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton print = new JButton("Print");
        JButton history  = new JButton("Show History");
        panel2.add(print);
        panel2.add(history);
        panel.add(field,BorderLayout.NORTH);
        panel.add(area,BorderLayout.CENTER);
        panel.add(panel2,BorderLayout.SOUTH);

        print.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                c.setString(field.getText());
                c.printString();
            }
            
        });

        history.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                area.setText(c.getHistory().toString());
            }

        });

        frame.setContentPane(panel);
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
       new SimpleGUI().display();
    }

}
