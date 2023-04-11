package Main.controller.home;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

import static Main.utility.UtilityClass.changeScene;
import static Main.utility.UtilityClass.runOnNewThread;

public class HomeViewController {
    @FXML
    private Button addAdminHome;
    @FXML
    private Button continueToMenu;

    @FXML
    private void onAddAdmin(javafx.event.ActionEvent event) throws IOException {
        runOnNewThread(()->{
            changeScene(event, "../views/home/home-add-admin.fxml");
        });
    }

    @FXML
    private void onContinueToMenu(javafx.event.ActionEvent event) throws IOException {
        runOnNewThread(()->{
            changeScene(event, "../views/admin/admin-menu.fxml");
        });
    }
}
