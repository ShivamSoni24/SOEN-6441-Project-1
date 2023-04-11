package Main.controller.admin;

import Main.models.property.Apartment;
import Main.models.property.Condo;
import Main.models.property.House;
import Main.models.property.Property;
import Main.models.user.Tenant;
import Main.repository.Filter;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import static Main.Main.*;
import static Main.utility.UtilityClass.*;

public class CreateContractController implements Initializable {
    @FXML private ComboBox selectTenant;
    @FXML private ComboBox selectProperty;
    @FXML private ComboBox contractDuration;
    @FXML private Label warningMessage;
    @FXML private TextField monthlyRent;
    @FXML private Button createContract;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        contractDuration.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
                "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24");
        contractDuration.getSelectionModel().selectFirst();
        selectTenant.setItems(getTenantsList());
        selectTenant.getSelectionModel().selectFirst();
        selectProperty.setItems(getPropertiesList(Filter.VACANT));
        selectProperty.getSelectionModel().selectFirst();
    }

    @FXML
    private void onback(javafx.event.ActionEvent event) {
        runOnNewThread(() -> {
            changeScene(event, "../views/admin/admin-menu.fxml");
        });
    }
    private void generateNewContract() throws Exception {
        String tenantID = getID(selectTenant.getSelectionModel().getSelectedItem().toString());
        String propertyID = getID(selectProperty.getSelectionModel().getSelectedItem().toString());
        int duration;
        duration = Integer.parseInt(contractDuration.getSelectionModel().getSelectedItem().toString());
        double rent;
        rent = Double.parseDouble(monthlyRent.getText());
        LocalDate endDate = LocalDate.now().plusMonths(duration);

        String contractID = contractController.rentUnit(tenantID, propertyID, endDate, rent);
        if(contractID.isEmpty())
            warningMessage.setText("Please check all fields data");
        else {
            warningMessage.setText("New contract created with ID: " + contractID);
            selectProperty.setItems(getPropertiesList(Filter.VACANT));
            selectProperty.getSelectionModel().selectFirst();
        }
    }
    @FXML
    private void onCreate(javafx.event.ActionEvent event){
        runOnNewThread(() -> {
            try {
                Platform.runLater(() -> {
                    try {
                        generateNewContract();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
