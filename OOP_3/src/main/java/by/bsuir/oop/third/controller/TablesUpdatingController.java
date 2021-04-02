package by.bsuir.oop.third.controller;

import java.net.URL;
import java.util.ResourceBundle;

import by.bsuir.oop.third.domain.furniture.Table;
import by.bsuir.oop.third.info.Info;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static java.lang.System.exit;

public class TablesUpdatingController {

    @FXML
    private TextField areaField;

    @FXML
    private TextField weightField;

    @FXML
    private Button updatingButton;

    @FXML
    void initialize() {
        Table table = TablesController.getTableToUpdate();
        areaField.setText(String.valueOf(table.getArea()));
        weightField.setText(String.valueOf(table.getWeight()));

        updatingButton.setOnAction(e -> {
            if (checkWeightField() && checkAreaField()){
                table.setArea(Integer.parseInt(areaField.getText()));
                table.setWeight(Integer.parseInt(weightField.getText()));
                showAlert("Info added", true);
            } else {
                showAlert("Some errors happened", false);
            }
        });
    }

    private boolean checkWeightField(){
        if (weightField.getText().equals("")){
            return false;
        } else if (weightField.getText().compareTo( Integer.toString(Integer.MAX_VALUE)) < 0) {
            return false;
        } else return weightField.getText().matches("[0-9]+");
    }

    private boolean checkAreaField(){
        if (areaField.getText().equals("")){
            return false;
        } else if (areaField.getText().compareTo( Integer.toString(Integer.MAX_VALUE)) < 0) {
            return false;
        } else return areaField.getText().matches("[0-9]+");
    }

    private void showAlert(String message, boolean state) {
        Alert alert = new Alert(state ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
        alert.setHeaderText(state ? "Information" : "Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
