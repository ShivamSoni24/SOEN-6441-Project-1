package Main.controller.admin;

import Main.models.user.Tenant;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static Main.Main.contractController;
import static Main.Main.userController;
import static Main.utility.UtilityClass.*;

public class CancelContractController implements Initializable {
    @FXML private ComboBox selectTenant;
    @FXML private ComboBox selectProperty;
    @FXML private TilePane tenantsTilePane;

    private void updateTenants(List<Tenant> tenants) {
        tenantsTilePane.getChildren().clear();

        if(!tenants.isEmpty()) {
            tenantsTilePane.setPadding(new Insets(10, 0, 0, 10));
            int i = 1;
            for (Tenant tenant : tenants) {
                VBox tile = new VBox();
                tile.autosize();
                tile.setAlignment(Pos.CENTER);
                tile.setPadding(new Insets(10));

                // Add a border to the tile
                tile.setStyle("-fx-border-color: black; -fx-border-width: 1px;");

                // Add a background color to the tile
                if (i % 2 == 0) {
                    tile.setStyle("-fx-background-color: #F3E23A; -fx-border-color: black; -fx-border-width: 1px;");
                } else {
                    tile.setStyle("-fx-background-color: #268396; -fx-border-color: black; -fx-border-width: 1px;");
                }

                // Add a serial number to the tile
                Label serialNo = new Label("Tenant #" + tenant.getId());
                serialNo.setWrapText(true);
                serialNo.setStyle("-fx-font-size: 14pt; -fx-font-weight: bold;");
                tile.getChildren().add(serialNo);
                i++;

                Label name = new Label("Name: " + tenant.getName());
                name.setWrapText(true);
                name.setStyle("-fx-font-size: 12pt;");
                tile.getChildren().add(name);

                Label email = new Label("Email: " + tenant.getEmail());
                email.setWrapText(true);
                email.setStyle("-fx-font-size: 12pt;");
                tile.getChildren().add(email);

                tenantsTilePane.getChildren().add(tile);
            }
        }
    }

    private void deleteContract() throws Exception {
        if(selectTenant.getValue() != null) {
            String tenantID = getID(selectTenant.getSelectionModel().getSelectedItem().toString());
            String propertyID = getID(selectProperty.getSelectionModel().getSelectedItem().toString());

            List<Tenant> tenants = contractController.terminateContract(propertyID, tenantID);
            updateTenants(tenants);

            selectProperty.setItems(getTenantProperties(getID(selectTenant.getSelectionModel().getSelectedItem().toString())));
            selectProperty.getSelectionModel().selectFirst();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectTenant.setItems(getTenantsList());
        selectTenant.getSelectionModel().selectFirst();

        if(selectTenant.getValue() != null) {
            selectProperty.setItems(getTenantProperties(getID(selectTenant.getSelectionModel().getSelectedItem().toString())));
            selectProperty.getSelectionModel().selectFirst();

            selectTenant.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                selectProperty.setItems(getTenantProperties(getID(selectTenant.getSelectionModel().getSelectedItem().toString())));
                selectProperty.getSelectionModel().selectFirst();
            });
        }
    }

    @FXML
    private void onCancelContract(javafx.event.ActionEvent event) {
        runOnNewThread(() -> {
            Platform.runLater(() -> {
                try {
                    deleteContract();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }

    @FXML
    private void onback(javafx.event.ActionEvent event) {
        runOnNewThread(() -> {
            changeScene(event, "../views/admin/admin-menu.fxml");
        });
    }
}
