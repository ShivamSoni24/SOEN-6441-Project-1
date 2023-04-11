package Main.controller.admin;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static Main.Main.propertyController;
import static Main.utility.UtilityClass.changeScene;
import static Main.utility.UtilityClass.runOnNewThread;

public class AddPropertyApartmentController {
    @FXML private TextField aptStreetName;
    @FXML private TextField aptCity;
    @FXML private TextField aptPostal;
    @FXML private TextField aptProvince;
    @FXML private TextField aptCountry;
    @FXML private TextField aptNoOfBedroom;
    @FXML private TextField aptNoOfBathrooms;
    @FXML private TextField aptSqftArea;
    @FXML private TextField aptNumber;
    @FXML private Label statusMessage;

    private void addApartmentToRepo() {
        if(aptStreetName.getText().isBlank() ||
            aptCity.getText().isBlank() ||
            aptPostal.getText().isBlank() ||
            aptProvince.getText().isBlank() ||
            aptCountry.getText().isBlank() ||
            aptNoOfBedroom.getText().isBlank() ||
            aptNoOfBathrooms.getText().isBlank() ||
            aptSqftArea.getText().isBlank() ||
            aptNumber.getText().isBlank()
        ) {
            statusMessage.setText("ALL FIELDS ARE MANDATORY");
        }
        else {
            String id = null;
            try {
                id = propertyController.addApartment(aptStreetName.getText(),
                        aptCity.getText(),
                        aptPostal.getText(),
                        aptProvince.getText(),
                        aptCountry.getText(),
                        Integer.parseInt(aptNumber.getText()),
                        Integer.parseInt(aptNoOfBedroom.getText()),
                        Integer.parseInt(aptNoOfBathrooms.getText()),
                        Double.parseDouble(aptSqftArea.getText()));
                statusMessage.setText("Property added with ID " + id);

                //clear textFields
                aptStreetName.clear();
                aptCity.clear();
                aptPostal.clear();
                aptProvince.clear();
                aptCountry.clear();
                aptNumber.clear();
                aptNoOfBedroom.clear();
                aptNoOfBathrooms.clear();
                aptSqftArea.clear();
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
