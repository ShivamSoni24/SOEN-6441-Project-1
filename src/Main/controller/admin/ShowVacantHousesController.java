package Main.controller.admin;

import Main.models.property.House;
import Main.repository.Filter;
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

import static Main.Main.propertyController;
import static Main.utility.UtilityClass.changeScene;
import static Main.utility.UtilityClass.runOnNewThread;

public class ShowVacantHousesController implements Initializable {
    @FXML
    private TilePane housesTilePane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<House> houses = propertyController.getAllHouses(Filter.VACANT);
        housesTilePane.getChildren().clear();
        housesTilePane.setPadding(new Insets(10, 0, 0, 10));
        int i = 1;
        for (House house : houses) {
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
            Label serialNo = new Label("House #" + Integer.toString(i));
            serialNo.setWrapText(true);
            serialNo.setStyle("-fx-font-size: 14pt; -fx-font-weight: bold;");
            tile.getChildren().add(serialNo);
            i++;

            Label address = new Label("Address: " + house.getStreetNo() + ", " + house.getStreetName() + ", " +
                    house.getCity() + ",\n" + house.getPostalCode() + ", " + house.getProvince() + ", " +
                    house.getCountry());
            address.setWrapText(true);
            address.setStyle("-fx-font-size: 12pt;");
            tile.getChildren().add(address);

            housesTilePane.getChildren().add(tile);
        }
    }

    @FXML
    private void onback(javafx.event.ActionEvent event) {
        runOnNewThread(() -> {
            changeScene(event, "../views/admin/admin-select-property-type.fxml");
        });
    }
}
