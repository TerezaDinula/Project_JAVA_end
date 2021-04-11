import Views.InputView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GuiMain");
        //Adds to the JFrame our main panel
        frame.setContentPane(new InputView().getMainPanel());
        //Set the default operation when closing the panel
        //In this case, exit the program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Changes the window size so that we can show every element
        frame.pack();
        //Make the JFrame visible
        frame.setVisible(true);
        //Setting the frame size to 500 x 500
        frame.setSize(500, 300);
    }
}