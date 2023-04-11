package Main.controller.admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static Main.Main.contractController;
import static Main.utility.UtilityClass.*;

public class AdminPayRentController implements Initializable {
    @FXML
    private ComboBox selectTenant;
    @FXML private ComboBox selectProperty;
    @FXML private ComboBox selectMonth;
    @FXML private Label payStatus;

    private void setMonth() {
        if(selectProperty.getValue() != null) {
            selectMonth.setItems(getMonths(getID(selectProperty.getSelectionModel().getSelectedItem().toString())));
            selectMonth.getSelectionModel().selectFirst();
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
                payStatus.setText("");
                try {
                    setMonth();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            selectProperty.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                payStatus.setText("");
                try {
                    setMonth();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            try {
                setMonth();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    private void onPayRent() throws Exception {
        String tenantID = getID(selectTenant.getSelectionModel().getSelectedItem().toString());
        String propertyID = getID(selectProperty.getSelectionModel().getSelectedItem().toString());
        String selectedMonth = selectMonth.getSelectionModel().getSelectedItem().toString();
        LocalDate date = LocalDate.parse("01 " + selectedMonth, DateTimeFormatter.ofPattern("dd MMMM ''yy"));
        int monthNumber = date.getMonthValue();
        int year = date.getYear();
        payStatus.setTextFill(Color.DARKGREEN);

        boolean isPaid = contractController.getRentStatus(propertyID, tenantID, monthNumber, year);
        if(isPaid) {
            payStatus.setText("RENT ALREADY PAID");
        }
        else {
            contractController.setRentStatus(propertyID, tenantID, monthNumber, year);
            payStatus.setText("SUCCESSFULLY PAID");
        }
    }

    @FXML
    private void onback(javafx.event.ActionEvent event) {
        runOnNewThread(() -> {
            changeScene(event, "../views/admin/admin-menu.fxml");
        });
    }
}
