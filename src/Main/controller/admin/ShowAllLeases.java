package Main.controller.admin;

import Main.models.Contract;
import Main.models.user.Tenant;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static Main.Main.contractController;
import static Main.utility.UtilityClass.changeScene;
import static Main.utility.UtilityClass.runOnNewThread;

public class ShowAllLeases implements Initializable {
    @FXML
    private TilePane contractsTilePane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Contract> contracts = contractController.getLeases();
        contractsTilePane.getChildren().clear();
        contractsTilePane.setPadding(new Insets(10, 0, 0, 10));
        int i = 1;
        for (Contract contract : contracts) {
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
            Label serialNo = new Label("Contract #" + i);
            serialNo.setWrapText(true);
            serialNo.setStyle("-fx-font-size: 14pt; -fx-font-weight: bold;");
            tile.getChildren().add(serialNo);
            i++;

            Label tenantID = new Label("Tenant ID: " + contract.getTenantId());
            tenantID.setWrapText(true);
            tenantID.setStyle("-fx-font-size: 12pt;");
            tile.getChildren().add(tenantID);

            Label propertyID = new Label("Property ID: " + contract.getPropertyId());
            propertyID.setWrapText(true);
            propertyID.setStyle("-fx-font-size: 12pt;");
            tile.getChildren().add(propertyID);

            Label sdate = new Label("Start Date: " + contract.getStartDate());
            sdate.setWrapText(true);
            sdate.setStyle("-fx-font-size: 12pt;");
            tile.getChildren().add(sdate);

            Label edate = new Label("End Date: " + contract.getEndDate());
            edate.setWrapText(true);
            edate.setStyle("-fx-font-size: 12pt;");
            tile.getChildren().add(edate);

            Label rent = new Label("Monthly Rent: " + contract.getMonthlyRate());
            rent.setWrapText(true);
            rent.setStyle("-fx-font-size: 12pt;");
            tile.getChildren().add(rent);

            contractsTilePane.getChildren().add(tile);
        }
    }

    @FXML
    private void onback(javafx.event.ActionEvent event) {
        runOnNewThread(() -> {
            changeScene(event, "../views/admin/admin-menu.fxml");
        });
    }
}
