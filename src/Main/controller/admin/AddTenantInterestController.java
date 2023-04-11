package Main.controller.admin;

import Main.repository.Filter;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

import static Main.Main.contractController;
import static Main.utility.UtilityClass.*;

public class AddTenantInterestController implements Initializable {
    @FXML private ComboBox selectTenant;
    @FXML private ComboBox selectProperty;
    @FXML private Label interestStatus;

    private void addTenantInterest() throws Exception {
        if(selectTenant.getValue() != null) {
            String tenantID = getID(selectTenant.getSelectionModel().getSelectedItem().toString());
            String propertyID = getID(selectProperty.getSelectionModel().getSelectedItem().toString());

            contractController.registerInterest(propertyID, tenantID);
            interestStatus.setText("Interest added successfully");
            interestStatus.setTextFill(Color.DARKGREEN);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectTenant.setItems(getTenantsList());
        selectTenant.getSelectionModel().selectFirst();

        if(selectTenant.getValue() != null) {
            selectProperty.setItems(nonTenantRentedProperties(getID(selectTenant.getSelectionModel().getSelectedItem().toString())));
            selectProperty.getSelectionModel().selectFirst();

            selectTenant.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                selectProperty.setItems(nonTenantRentedProperties(getID(selectTenant.getSelectionModel().getSelectedItem().toString())));
                selectProperty.getSelectionModel().selectFirst();
                interestStatus.setText("");
            });
        }

        selectProperty.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            interestStatus.setText("");
        });
    }

    @FXML
    private void onAddInterest(ActionEvent event) {
        runOnNewThread(() -> {
            try {
                Platform.runLater(() ->{
                    try {
                        addTenantInterest();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @FXML
    private void onback(javafx.event.ActionEvent event) {
        runOnNewThread(() -> {
            changeScene(event, "../views/admin/admin-menu.fxml");
        });
    }
}
