package Main.utility;

import Main.models.Contract;
import Main.models.property.Apartment;
import Main.models.property.Condo;
import Main.models.property.House;
import Main.models.property.Property;
import Main.models.user.Tenant;
import Main.repository.Filter;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static Main.Main.*;

public class UtilityClass {
    private static Stage stage;
    private static Scene scene;
    private static Parent root;

    private UtilityClass() {
    }

    public static void changeScene(ActionEvent event, String fxmlPath) {
        runOnNewThread(() -> {
            try {
                root = FXMLLoader.load(Objects.requireNonNull(UtilityClass.class.getResource(fxmlPath)));
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                Platform.runLater(() -> {
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void runOnNewThread(Runnable runnable) {
        Thread thread = new Thread(() -> {
            try {
                runnable.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }
    public static ObservableList<String> getTenantsList() {
        ObservableList<String> tenantsList = FXCollections.observableArrayList();
        List<Tenant> tenants = userController.getTenants();
        for (Tenant tenant : tenants) {
            tenantsList.add("#" + tenant.getId() + " " + tenant.getName());
        }
        return tenantsList;
    }

    public static ObservableList<String> getPropertiesList(Filter filter) {

        ObservableList<String> propertiesList = FXCollections.observableArrayList();

        List<Property> properties = propertyController.getAllProperties(filter);
        for(Property property : properties) {

            if(property instanceof Apartment apartment)
            {
                propertiesList.add("#" + apartment.getId() + " : APARTMENT : " + apartment.getAptNo() + ", " +
                        apartment.getStreetName());
            }
            else if (property instanceof Condo condo)
            {
                propertiesList.add("#" + condo.getId() + " : CONDO : " + condo.getCondoNo() + ", " +
                        condo.getStreetName());
            }
            else if (property instanceof House house)
            {
                propertiesList.add("#" + house.getId() + " : HOUSE : " + house.getStreetNo() + ", " +
                        house.getStreetName());
            }
        }
        return propertiesList;
    }

    public static String getID(String inputString) {
        String[] words = inputString.split(" ");
        return words[0].substring(1);
    }

    public static ObservableList<String> getTenantProperties(String tenantID) {
        ObservableList<String> tenantProperties = FXCollections.observableArrayList();

        List<Contract> contracts = contractController.getLeases();
        contracts.removeIf(contract -> !contract.getTenantId().equals(tenantID));

        List<Property> properties = propertyController.getAllProperties(Filter.RENTED);
        for(Contract contract : contracts) {
            for(Property property : properties) {
                if(property.getId().equals(contract.getPropertyId())) {
                    if(property instanceof Apartment apartment)
                    {
                        tenantProperties.add("#" + apartment.getId() + " : APARTMENT : " + apartment.getAptNo() + ", " +
                                apartment.getStreetName());
                    }
                    else if (property instanceof Condo condo)
                    {
                        tenantProperties.add("#" + condo.getId() + " : CONDO : " + condo.getCondoNo() + ", " +
                                condo.getStreetName());
                    }
                    else if (property instanceof House house)
                    {
                        tenantProperties.add("#" + house.getId() + " : HOUSE : " + house.getStreetNo() + ", " +
                                house.getStreetName());
                    }
                }
            }
        }
        return tenantProperties;
    }

    public static ObservableList<String> nonTenantRentedProperties(String tenantID) {
        ObservableList<String> nonTenantProperties = FXCollections.observableArrayList();

        List<Contract> contracts = contractController.getLeases();
        contracts.removeIf(contract -> contract.getTenantId().equals(tenantID));

        List<Property> properties = propertyController.getAllProperties(Filter.RENTED);
        for(Contract contract : contracts) {
            for(Property property : properties) {
                if(property.getId().equals(contract.getPropertyId())) {
                    if(property instanceof Apartment apartment)
                    {
                        nonTenantProperties.add("#" + apartment.getId() + " : APARTMENT : " + apartment.getAptNo() + ", " +
                                apartment.getStreetName());
                    }
                    else if (property instanceof Condo condo)
                    {
                        nonTenantProperties.add("#" + condo.getId() + " : CONDO : " + condo.getCondoNo() + ", " +
                                condo.getStreetName());
                    }
                    else if (property instanceof House house)
                    {
                        nonTenantProperties.add("#" + house.getId() + " : HOUSE : " + house.getStreetNo() + ", " +
                                house.getStreetName());
                    }
                }
            }
        }

        return nonTenantProperties;
    }

    public static ObservableList<String> getMonths(String propertyID) {
        ObservableList<String> months = FXCollections.observableArrayList();
        LocalDate sDate = LocalDate.now(), eDate = LocalDate.now();

        List<Contract> contracts = contractController.getLeases();
        for(Contract contract : contracts) {
            if(contract.getPropertyId().equals(propertyID)) {
                sDate = contract.getStartDate();
                eDate = contract.getEndDate();
                break;
            }
        }

        while (!(sDate.equals(eDate))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
                    .withLocale(Locale.getDefault());
            String monthName = formatter.format(sDate).split(" ")[0];
            String year = formatter.format(sDate).split(" ")[2].substring(2);
            String month = monthName.substring(0, 1).toUpperCase() + monthName.substring(1).toLowerCase();
            months.add(month + " '" + year);
            sDate = sDate.plusMonths(1);
        }

        return months;
    }
}
