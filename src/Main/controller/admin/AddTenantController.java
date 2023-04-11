package Main.controller.admin;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static Main.Main.userController;
import static Main.utility.UtilityClass.changeScene;
import static Main.utility.UtilityClass.runOnNewThread;

public class AddTenantController {

    @FXML
    private TextField tenantName;
    @FXML private TextField tenantEmail;
    @FXML private TextField tenantPhoneNumber;
    @FXML private Label warningMessage;

    private void addTenantToRepo() {
        if(tenantName.getText().isBlank() || tenantEmail.getText().isBlank() || tenantPhoneNumber.getText().isBlank())
            warningMessage.setText("ALL FIELDS ARE MANDATORY");
        else {
            String id = userController.addTenant(tenantName.getText(), tenantEmail.getText(), tenantPhoneNumber.getText());
            warningMessage.setText("Tenant added with ID " + id);

            // clear textFields
            tenantName.clear();
            tenantEmail.clear();
            tenantPhoneNumber.clear();
        }
    }
    @FXML
    private void onSubmit(javafx.event.ActionEvent event) {
        runOnNewThread(() -> {
            Platform.runLater(this::addTenantToRepo);
        });
    }

    @FXML
    private void onHome(javafx.event.ActionEvent event) {
        runOnNewThread(() -> {
            changeScene(event, "../views/admin/admin-menu.fxml");
        });
    }
}
