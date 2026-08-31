import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox dialogContainer;

    @FXML
    private TextField userInput;

    @FXML
    private Button sendButton;

    private Duke duke;

    private Image userImage = new Image(
            this.getClass().getResourceAsStream("/images/DaUser.png"));

    private Image dukeImage = new Image(
            this.getClass().getResourceAsStream("/images/DaDuke.png"));

    /**
     * Initializes the controller after the FXML elements have been loaded.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(
                dialogContainer.heightProperty());
    }

    /**
     * Injects the Duke instance used to generate responses.
     *
     * @param duke Duke instance to use
     */
    public void setDuke(Duke duke) {
        this.duke = duke;
    }

    /**
     * Displays the user's input and Duke's response, then clears the input.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = duke.getResponse(input);

        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, dukeImage));

        userInput.clear();
    }
}