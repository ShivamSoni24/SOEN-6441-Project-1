package Main.controller.admin;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static Main.Main.propertyController;
import static Main.utility.UtilityClass.changeScene;
import static Main.utility.UtilityClass.runOnNewThread;

public class AddPropertyHouseController {
    @FXML
    private TextField houseStreetName;
    @FXML private TextField houseCity;
    @FXML private TextField housePostal;
    @FXML private TextField houseProvince;
    @FXML private TextField houseCountry;
    @FXML private TextField houseNumber;
    @FXML private Label statusMessage;

    private void addApartmentToRepo() {
        if(houseStreetName.getText().isBlank() ||
                houseCity.getText().isBlank() ||
                housePostal.getText().isBlank() ||
                houseProvince.getText().isBlank() ||
                houseCountry.getText().isBlank() ||
                houseNumber.getText().isBlank()
        ) {
            statusMessage.setText("ALL FIELDS ARE MANDATORY");
        }
        else {
            String id = null;
            try {
                id = propertyController.addHouse(houseStreetName.getText(),
                        houseCity.getText(),
                        housePostal.getText(),
                        houseProvince.getText(),
                        houseCountry.getText(),
                        Integer.parseInt(houseNumber.getText()));
                statusMessage.setText("Property added with ID " + id);

                // clear textFields
                houseCity.clear();
                housePostal.clear();
                houseProvince.clear();
                houseCountry.clear();
                houseNumber.clear();
            } catch (Exception e) {
                statusMessage.setText("Datatype mismatch with fields");
            }
        }
    }
    @FXML
    private void onSubmit(javafx.event.ActionEvent event) {
        runOnNewThread(() -> {
            Platform.runLater(this::addApartmentToRepo);
        });
    }

    @FXML
    private void onback(javafx.event.ActionEvent event) {
        runOnNewThread(() -> {
            changeScene(event, "../views/admin/admin-select-property-type.fxml");
        });
    }
}
