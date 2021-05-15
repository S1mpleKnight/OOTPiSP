package by.bsuir.oop.fourth.controller;

import by.bsuir.oop.fourth.domain.furniture.Table;
import by.bsuir.oop.fourth.domain.maker.Manufacturer;
import by.bsuir.oop.fourth.util.Info;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class TablesAdditionController {
    private String choice;
    @FXML
    private TextField areaField;
    @FXML
    private TextField legsField;
    @FXML
    private Button additionButton;
    @FXML
    private ComboBox<String> makersComboBox;

    @FXML
    void initialize() {
        List<String> makers = Arrays.stream(Manufacturer.values())
                .map(Manufacturer::toString)
                .collect(Collectors.toList());
        ObservableList<String> makersList = FXCollections.observableArrayList(makers);
        makersComboBox.getItems().addAll(makersList);
        makersComboBox.setOnAction(e -> {
            choice = makersComboBox.getValue();
        });

        additionButton.setOnAction(e -> {
            if (checkLegsField() && checkAreaField() && checkMakerField()) {
                int legs = Integer.parseInt(legsField.getText());
                int area = Integer.parseInt(areaField.getText());
                Manufacturer maker = Manufacturer.valueOf(choice);
                Info.getInfo().getTables().getList().add(new Table(maker, legs, area));
                reset();
                showAlert("Info added", true);
            } else {
                showAlert("Some errors happened", false);
            }
        });
    }

    private void reset() {
        areaField.setText("");
       legsField.setText("");
    }

    private boolean checkMakerField(){
        return choice != null;
    }

    private boolean checkLegsField() {
        if (legsField.getText().equals("")) {
            return false;
        } else if (legsField.getText().length() >= 10) {
            return false;
        } else return legsField.getText().matches("[0-9]+");
    }

    private boolean checkAreaField() {
        if (areaField.getText().equals("")) {
            return false;
        } else if (areaField.getText().length() >= 10) {
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
