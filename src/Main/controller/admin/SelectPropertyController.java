package Main.controller.admin;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import static Main.controller.home.HomeMenuController.selectedOption;
import static Main.utility.UtilityClass.changeScene;
import static Main.utility.UtilityClass.runOnNewThread;

public class SelectPropertyController {
    private static final String AddPropertyOption = "Add a property";
    private static final String DisplayPropertyOption = "Display properties";
    private static final String DisplayRentedOption = "Display rented units";
    private static final String DisplayVacantOption = "Display vacant units";
    private void apartmentScene(ActionEvent event) {
        switch (selectedOption) {
            case AddPropertyOption -> changeScene(event, "../views/admin/admin-add-property-apartment.fxml");
            case DisplayPropertyOption -> changeScene(event, "../views/admin/admin-display-apartments.fxml");
            case DisplayRentedOption -> changeScene(event, "../views/admin/admin-display-rented-apartments.fxml");
            case DisplayVacantOption -> changeScene(event, "../views/admin/admin-display-vacant-apartments.fxml");
        }
    }

    private void condoScene(ActionEvent event) {
        switch (selectedOption) {
            case AddPropertyOption -> changeScene(event, "../views/admin/admin-add-property-condo.fxml");
            case DisplayPropertyOption -> changeScene(event, "../views/admin/admin-display-condos.fxml");
            case DisplayRentedOption -> changeScene(event, "../views/admin/admin-display-rented-condos.fxml");
            case DisplayVacantOption -> changeScene(event, "../views/admin/admin-display-vacant-condos.fxml");
        }
    }

    private void houseScene(ActionEvent event) {
        switch (selectedOption) {
            case AddPropertyOption -> changeScene(event, "../views/admin/admin-add-property-house.fxml");
            case DisplayPropertyOption -> changeScene(event, "../views/admin/admin-display-houses.fxml");
            case DisplayRentedOption -> changeScene(event, "../views/admin/admin-display-rented-houses.fxml");
            case DisplayVacantOption -> changeScene(event, "../views/admin/admin-display-vacant-houses.fxml");
        }
    }
    @FXML
    private void onBack(ActionEvent event) {
        changeScene(event, "../views/admin/admin-menu.fxml");
    }

    @FXML
    private void onApartment(ActionEvent event) {
        runOnNewThread(() -> Platform.runLater(() -> {
            apartmentScene(event);
        }));
    }

    @FXML
    private void onCondo(ActionEvent event) {
        runOnNewThread(() -> Platform.runLater(() -> {
            condoScene(event);
        }));
    }

    @FXML
    private void onHouse(ActionEvent event) {
        runOnNewThread(() -> Platform.runLater(() -> {
            houseScene(event);
        }));
    }
}
