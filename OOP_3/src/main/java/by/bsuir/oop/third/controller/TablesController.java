package by.bsuir.oop.third.controller;

import by.bsuir.oop.third.domain.furniture.Table;
import by.bsuir.oop.third.info.Info;
import by.bsuir.oop.third.starter.Main;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TablesController {
    private static Table tableToUpdate;
    private DTO dto;
    private ArrayList<DTO> dtos;
    private ObservableList<DTO> tables;

    @FXML
    private Button addButton;

    @FXML
    private Button backButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;

    @FXML
    private TableView<DTO> tableTables;

    @FXML
    private TableColumn<DTO, String> areaColumn;

    @FXML
    private TableColumn<DTO, String> weightColumn;

    private static ArrayList<DTO> convert(List<Table> tables) {
        ArrayList<DTO> dtos = new ArrayList<>();
        for (Table table : tables) {
            dtos.add(new DTO(table.getArea(), table.getWeight()));
        }
        return dtos;
    }

    public static Table getTableToUpdate() {
        return tableToUpdate;
    }

    @FXML
    void initialize() {
        areaColumn.setCellValueFactory(area -> area.getValue().area.asString());
        weightColumn.setCellValueFactory(weight -> weight.getValue().weight.asString());
        dtos = convert(Info.getInfo().getTables().getList());
        tables = FXCollections.observableArrayList(dtos);
        tableTables.setItems(tables);

        TableView.TableViewSelectionModel<DTO> selected = tableTables.getSelectionModel();
        selected.selectedItemProperty().addListener((observable, oldValue, newValue) -> dto = newValue);

        deleteButton.setOnAction(e -> {
            if (dto != null) {
                int index = dtos.indexOf(dto);
                dtos.remove(index);
                Info.getInfo().getTables().getList().remove(index);
                tableTables.setItems(FXCollections.observableArrayList(dtos));
            }
        });

        addButton.setOnAction(e -> {
            Stage stage = new Stage();
            try {
                Main.getStage().hide();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("tablesAddition.fxml"))));
                stage.setResizable(false);
                stage.setTitle("Addition");
                stage.showAndWait();
                reset();
                Main.getStage().show();
            } catch (IOException exception) {
                showAlert(exception.getMessage(), false);
            }
        });

        updateButton.setOnAction(e -> {
            if (dto != null) {
                tableToUpdate = Info.getInfo().getTables().getList().get(dtos.indexOf(dto));
                try {
                    showUpdating();
                } catch (IOException exception) {
                    showAlert(exception.getMessage(), false);
                }
            } else {
                showAlert("Select row", false);
            }
        });

        backButton.setOnAction(e -> {
            Main.getStage().setScene(Main.getMainScene());
        });
    }

    private void showUpdating() throws IOException {
        Stage stage = new Stage();
        Main.getStage().hide();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("tablesUpdating.fxml"))));
        stage.setResizable(false);
        stage.setTitle("Updating");
        stage.showAndWait();
        reset();
        Main.getStage().show();
    }

    private void reset() {
        dtos = convert(Info.getInfo().getTables().getList());
        tables = FXCollections.observableArrayList(dtos);
        tableTables.setItems(tables);
    }

    private void showAlert(String message, boolean state) {
        Alert alert = new Alert(state ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
        alert.setHeaderText(state ? "Information" : "Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private static class DTO {
        IntegerProperty area;
        IntegerProperty weight;

        public DTO(Integer area, Integer weight) {
            this.area = new SimpleIntegerProperty(area);
            this.weight = new SimpleIntegerProperty(weight);
        }
    }
}
