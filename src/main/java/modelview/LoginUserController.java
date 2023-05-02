package modelview;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.mycompany.mvvmexample.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginUserController {
    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button returnButton;
    protected static String loggedInName;

    @FXML
    private void loginUser(ActionEvent actionEvent) {
        try {
            AccessFBView.loggedInName = App.fauth.getUserByEmail(emailField.getText()).getDisplayName();
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void returnBack(ActionEvent actionEvent) throws IOException {
        App.setRoot("AccessFBView.fxml");
    }
}
