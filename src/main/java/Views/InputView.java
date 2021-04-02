package Views;

import Controllers.InputController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputView {

    private JTextField textField1;
    private JButton showRatingForTheButton;
    private JButton showActorsWhichBornButton;
    private JPanel mainPanel;
    private InputController controller;


    public InputView() {
        controller = new InputController ("https://imdb8.p.rapidapi.com/auto-complete?q=titanic");

        showActorsWhichBornButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        showRatingForTheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
