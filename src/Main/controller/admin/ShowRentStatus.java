package Main.controller.admin;

import Main.models.Contract;
import Main.models.user.Tenant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static Main.Main.contractController;
import static Main.Main.userController;
import static Main.utility.UtilityClass.*;

public class ShowRentStatus implements Initializable {
    @FXML private ComboBox selectTenant;
    @FXML private ComboBox selectProperty;
    @FXML private ComboBox selectMonth;
    @FXML private Label rentStatus;

    private void setRentStatus() throws Exception {
        rentStatus.setText("");
        if(selectProperty.getValue() != null) {
            String tenantID = getID(selectTenant.getSelectionModel().getSelectedItem().toString());
            String propertyID = getID(selectProperty.getSelectionModel().getSelectedItem().toString());
            String selectedMonth = selectMonth.getSelectionModel().getSelectedItem().toString();
            LocalDate date = LocalDate.parse("01 " + selectedMonth, DateTimeFormatter.ofPattern("dd MMMM ''yy"));
            int monthNumber = date.getMonthValue();
            int year = date.getYear();

            boolean isPaid = contractController.getRentStatus(propertyID, tenantID, monthNumber, year);
            if(isPaid) {
                rentStatus.setText("RENT PAID");
                rentStatus.setTextFill(Color.DARKGREEN);
            }
            else {
                rentStatus.setText("RENT IS UNPAID");
                rentStatus.setTextFill(Color.DARKRED);
            }
        }
    }
    private void setMonths() throws Exception {
        selectMonth.getSelectionModel().clearSelection();
        if(selectProperty.getValue() != null)
        {
            selectMonth.setItems(getMonths(getID(selectProperty.getSelectionModel().getSelectedItem().toString())));
            selectMonth.getSelectionModel().selectFirst();

            setRentStatus();
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
                try {
                    setMonths();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            selectProperty.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    setMonths();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            try {
                setMonths();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            
            selectMonth.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    setRentStatus();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    @FXML
    private void onback(javafx.event.ActionEvent event) {
        runOnNewThread(() -> {
            changeScene(event, "../views/admin/admin-menu.fxml");
        });
    }
}
