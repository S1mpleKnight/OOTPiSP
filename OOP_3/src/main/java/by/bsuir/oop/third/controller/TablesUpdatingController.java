package by.bsuir.oop.third.controller;

import by.bsuir.oop.third.domain.furniture.Table;
import by.bsuir.oop.third.domain.maker.Manufacturer;
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

public class TablesUpdatingController {
    String choice;
    @FXML
    private TextField areaField;
    @FXML
    private TextField legsField;
    @FXML
    private Button updatingButton;
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

        Table table = TablesController.getTableToUpdate();
        areaField.setText(String.valueOf(table.getArea()));
        legsField.setText(String.valueOf(table.getNumberOfLegs()));
        choice = table.getMaker().toString();
        makersComboBox.setValue(makersList.get(table.getMaker().ordinal()));

        updatingButton.setOnAction(e -> {
            if (checkLegsField() && checkAreaField()){
                table.setArea(Integer.parseInt(areaField.getText()));
                table.setNumberOfLegs(Integer.parseInt(legsField.getText()));
                table.setMaker(Manufacturer.valueOf(choice));
                showAlert("Info updated", true);
            } else {
                showAlert("Some errors happened", false);
            }
        });
    }

    private boolean checkLegsField(){
        if (legsField.getText().equals("")){
            return false;
        } else if (legsField.getText().length() >= 10) {
            return false;
        } else return legsField.getText().matches("[0-9]+");
    }

    private boolean checkAreaField(){
        if (areaField.getText().equals("")){
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
