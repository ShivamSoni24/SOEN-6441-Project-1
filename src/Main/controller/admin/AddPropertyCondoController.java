package Main.controller.admin;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static Main.Main.propertyController;
import static Main.utility.UtilityClass.changeScene;
import static Main.utility.UtilityClass.runOnNewThread;

public class AddPropertyCondoController {
    @FXML
    private TextField condoStreetName;
    @FXML private TextField condoCity;
    @FXML private TextField condoPostal;
    @FXML private TextField condoProvince;
    @FXML private TextField condoCountry;
    @FXML private TextField condoNoOfBedroom;
    @FXML private TextField condoNoOfBathrooms;
    @FXML private TextField condoSqftArea;
    @FXML private TextField condoNumber;
    @FXML private Label statusMessage;

    private void addCondoToRepo() {
        if(condoStreetName.getText().isBlank() ||
                condoCity.getText().isBlank() ||
                condoPostal.getText().isBlank() ||
                condoProvince.getText().isBlank() ||
                condoCountry.getText().isBlank() ||
                condoNoOfBedroom.getText().isBlank() ||
                condoNoOfBathrooms.getText().isBlank() ||
                condoSqftArea.getText().isBlank() ||
                condoNumber.getText().isBlank()
        ) {
            statusMessage.setText("ALL FIELDS ARE MANDATORY");
        }
        else {
            String id = null;
            try {
                id = propertyController.addCondo(condoStreetName.getText(),
                        condoCity.getText(),
                        condoPostal.getText(),
                        condoProvince.getText(),
                        condoCountry.getText(),
                        Integer.parseInt(condoNumber.getText()),
                        Integer.parseInt(condoNoOfBedroom.getText()),
                        Integer.parseInt(condoNoOfBathrooms.getText()),
                        Double.parseDouble(condoSqftArea.getText()));
                statusMessage.setText("Property added with ID " + id);

                condoStreetName.clear();
                condoCity.clear();
                condoPostal.clear();
                condoProvince.clear();
                condoCountry.clear();
                condoNumber.clear();
                condoNoOfBedroom.clear();
                condoNoOfBathrooms.clear();
                condoSqftArea.clear();
            } catch (Exception e) {
                statusMessage.setText("Datatype mismatch with fields");
            }
        }
    }
    @FXML
    private void onSubmit(javafx.event.ActionEvent event) {
        runOnNewThread(() -> {
            Platform.runLater(this::addCondoToRepo);
        });
    }

    @FXML
    private void onback(javafx.event.ActionEvent event) {
        runOnNewThread(() -> {
            changeScene(event, "../views/admin/admin-select-property-type.fxml");
        });
    }
}
