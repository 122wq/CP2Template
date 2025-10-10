import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;      

public class HelloWorldSwing {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        JLabel label2 = new JLabel("Greatest Java programmer");
        JButton button = new JButton("Press Me");
        button.setSize(100,50);
        JButton button2 = new JButton("Press Me2");
        button2.setSize(100,50);
        button2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            label.setText("you did it.");
         }
        });   
        button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            label.setText("Ok Button clicked.");
         }
        });
        //screens
        JPanel cardPanel = new JPanel();
        CardLayout newLayout = new CardLayout();
        cardPanel.setLayout(newLayout);
        
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p1.setLayout(new GridLayout(2, 2));
        p1.add(button);
        p1.add(button2);
        p1.add(label);
        p2.add(label2);
        cardPanel.add(p1,"1");
        cardPanel.add(p2, "2");
        //menu
        final JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem screen1 = new JMenuItem("Screen1");
        screen1.setActionCommand("Screen1");
        screen1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newLayout.show(cardPanel, "1");
            } 
        });
        JMenuItem screen2 = new JMenuItem("Screen2");
        screen2.setActionCommand("Screen2");
        screen2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newLayout.show(cardPanel, "2");
            } 
        });
        menu.add(screen1);
        menu.add(screen2);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        

        frame.getContentPane().add(cardPanel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
      
}

