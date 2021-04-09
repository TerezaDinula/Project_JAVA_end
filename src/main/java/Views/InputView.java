package Views;

import Controllers.ActorController;
import Controllers.InputController;
import Models.ActorModel;
import Models.MovieModel;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.util.List;

public class InputView {

    private JTextField userInputField;
    private JButton showRatingButton;
    private JButton showActorsButton;
    private JPanel mainPanel;
    private JScrollPane outputScrollPane;
    private final InputController controller; //final never changes it's value
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
                builder.append(model.getName()).append("\n");
            }
            JOptionPane.showMessageDialog(mainPanel, builder.toString());
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}

