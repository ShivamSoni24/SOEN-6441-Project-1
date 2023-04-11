package Main.controller.admin;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static Main.Main.userController;
import static Main.utility.UtilityClass.changeScene;
import static Main.utility.UtilityClass.runOnNewThread;

public class AddAdminController {

    @FXML private TextField adminUsername;
    @FXML private TextField adminEmail;
    @FXML private TextField adminPhoneNumber;
    @FXML private Label warningMessage;

    private void addAdminToRepo() {
        if(adminUsername.getText().isBlank() || adminEmail.getText().isBlank() || adminPhoneNumber.getText().isBlank())
            warningMessage.setText("ALL FIELDS ARE MANDATORY");
        else {
            String id = userController.addAdmin(adminUsername.getText(), adminEmail.getText(), adminPhoneNumber.getText());
            warningMessage.setText("Admin added with ID " + id);

            adminUsername.clear();
            adminEmail.clear();
            adminPhoneNumber.clear();
        }
    }
    @FXML
    private void onSubmit(javafx.event.ActionEvent event) {
        Platform.runLater(this::addAdminToRepo);
    }

    @FXML
    private void onHome(javafx.event.ActionEvent event) {
        runOnNewThread(() -> {
            changeScene(event, "../views/admin/admin-menu.fxml");
        });
    }
}
