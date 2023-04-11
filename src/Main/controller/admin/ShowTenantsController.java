package Main.controller.admin;

import Main.models.user.Tenant;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static Main.Main.userController;
import static Main.utility.UtilityClass.changeScene;
import static Main.utility.UtilityClass.runOnNewThread;

public class ShowTenantsController implements Initializable {
    @FXML
    private TilePane tenantsTilePane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Tenant> tenants = userController.getTenants();
        tenantsTilePane.getChildren().clear();
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
            Label serialNo = new Label("Tenant #" + i);
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

            Label phone = new Label("Phone no: " + tenant.getPhoneNo());
            phone.setWrapText(true);
            phone.setStyle("-fx-font-size: 12pt;");
            tile.getChildren().add(phone);

            tenantsTilePane.getChildren().add(tile);
        }
    }

    @FXML
    private void onback(javafx.event.ActionEvent event) {
        runOnNewThread(() -> {
            changeScene(event, "../views/admin/admin-menu.fxml");
        });
    }
}
