package by.bsuir.oop.third.controller;

import by.bsuir.oop.third.domain.furniture.Table;
import by.bsuir.oop.third.info.Info;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TablesAdditionController {
    @FXML
    private TextField areaField;
    @FXML
    private TextField weightField;
    @FXML
    private Button additionButton;

    @FXML
    void initialize() {
        additionButton.setOnAction(e -> {
            if (checkWeightField() && checkAreaField()) {
                int weight = Integer.parseInt(weightField.getText());
                int area = Integer.parseInt(areaField.getText());
                Info.getInfo().getTables().getList().add(new Table(weight, area));
                reset();
                showAlert("Info added", true);
            } else {
                showAlert("Some errors happened", false);
            }
        });
    }

    private void reset() {
        areaField.setText("");
        weightField.setText("");
    }

    private boolean checkWeightField() {
        if (weightField.getText().equals("")) {
            return false;
        } else return weightField.getText().matches("[0-9]+");
    }

    private boolean checkAreaField() {
        if (areaField.getText().equals("")) {
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
