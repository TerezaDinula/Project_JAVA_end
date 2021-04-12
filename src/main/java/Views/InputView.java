package Views;

import Controllers.ActorController;
import Controllers.InputController;
import Models.ActorModel;
import Models.MovieModel;

import javax.swing.*;
import java.util.List;

public class InputView {

    private JTextField userInputField;
    private JButton showRatingButton;
    private JButton showActorsButton;
    private JPanel mainPanel;
    private final InputController controller;
    private final ActorController actorController;

    public InputView() {
        controller = new InputController("https://imdb8.p.rapidapi.com");
        actorController = new ActorController("https://imdb8.p.rapidapi.com");

        showRatingButton.addActionListener(e -> {
            MovieModel model = controller.getRating(userInputField.getText());
            JOptionPane.showMessageDialog(mainPanel, model.getTitle() + ", " + model.getRating());
        });

        showActorsButton.addActionListener(e -> {
            List<ActorModel> models = (List<ActorModel>) actorController.getActorIds();
            StringBuilder builder = new StringBuilder();
            for (ActorModel model : models) {
                builder.append(model.getName()).append(", ");
            }
            builder.setLength(builder.length() - 2);
            JTextArea responseMessage = new JTextArea(builder.toString(),4,70);
            responseMessage.setWrapStyleWord(true);
            responseMessage.setLineWrap(true);
            responseMessage.setOpaque(false);
            responseMessage.setBorder(null);
            responseMessage.setEditable(false);
            responseMessage.setFocusable(false);
            JOptionPane.showMessageDialog(mainPanel, responseMessage);
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}

