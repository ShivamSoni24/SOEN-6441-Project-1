package Main.controller.home;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import static Main.utility.UtilityClass.changeScene;
import static Main.utility.UtilityClass.runOnNewThread;

public class HomeMenuController {

    public static String selectedOption = "Add a property";
    @FXML
    private void onBackToAddAdminOp(javafx.event.ActionEvent event) {
        changeScene(event, "../views/home/home-add-admin.fxml");
    }

    @FXML
    private void onAddAProperty(javafx.event.ActionEvent event) {
        changeScene(event, "../views/admin/admin-select-property-type.fxml");
        selectedOption = "Add a property";
    }

    @FXML
    private void onAddTenant(javafx.event.ActionEvent event) {
        changeScene(event, "../views/admin/admin-add-tenant.fxml");
    }

    @FXML
    private void onDisplayTenants(ActionEvent event) {
        changeScene(event, "../views/admin/admin-display-tenants.fxml");
    }

    @FXML
    private void onDisplayProperties(ActionEvent event) {
        runOnNewThread(() -> Platform.runLater(() -> {
            changeScene(event, "../views/admin/admin-select-property-type.fxml");
            selectedOption = "Display properties";
        }));
    }

    @FXML
    private void onDisplayRentedUnits(ActionEvent event) {
        changeScene(event, "../views/admin/admin-select-property-type.fxml");
        selectedOption = "Display rented units";
    }

    @FXML
    private void onDisplayVacantUnits(ActionEvent event) {
        changeScene(event, "../views/admin/admin-select-property-type.fxml");
        selectedOption = "Display vacant units";
    }

    @FXML
    private void onCreateContract(ActionEvent event) {
        changeScene(event, "../views/admin/admin-create-contract.fxml");
    }

    @FXML
    private void onDisplayAllLeases(ActionEvent event) {
        changeScene(event, "../views/admin/admin-display-leases.fxml");
    }

    @FXML
    private void onGetRentStatus(ActionEvent event) {
        changeScene(event, "../views/admin/admin-get-rent-status.fxml");
    }

    @FXML
    private void onPayRent(ActionEvent event) {
        changeScene(event, "../views/admin/admin-pay-rent.fxml");
    }

    @FXML
    private void onEnterTenantInterest(ActionEvent event) {
        changeScene(event, "../views/admin/admin-add-tenant-interest.fxml");
    }

    @FXML
    private void onCancelContract(ActionEvent event) {
        changeScene(event, "../views/admin/admin-cancel-contract.fxml");
    }
}
