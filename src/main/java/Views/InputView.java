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
            List<ActorModel> models = actorController.getActorId();
            StringBuilder builder = new StringBuilder();
            for (ActorModel model : models) {
                builder.append(model.getId()).append(", ");
            }
            JOptionPane.showMessageDialog(mainPanel, builder.toString());
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}