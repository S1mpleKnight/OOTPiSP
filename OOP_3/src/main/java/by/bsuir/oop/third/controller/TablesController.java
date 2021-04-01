package by.bsuir.oop.third.controller;

import by.bsuir.oop.third.furniture.Table;
import by.bsuir.oop.third.info.Info;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TablesController {
    DTO dto;
    @FXML
    private Button addButton;

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

    @FXML
    void initialize() {
        areaColumn.setCellValueFactory(area -> area.getValue().area.asString());
        weightColumn.setCellValueFactory(weight -> weight.getValue().weight.asString());
        ArrayList<DTO> dtos = convert(Info.getInfo().getTables().getList());
        ObservableList<DTO> tables = FXCollections.observableArrayList(dtos);
        tableTables.setItems(tables);

        TableView.TableViewSelectionModel<DTO> selected = tableTables.getSelectionModel();
        selected.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            dto = newValue;
        });

        deleteButton.setOnAction(e -> {
            if (dto != null) {
                int index = dtos.indexOf(dto);
                dtos.remove(index);
                Info.getInfo().getTables().getList().remove(index);
                tableTables.setItems(FXCollections.observableArrayList(dtos));
            }
        });
    }

    private static ArrayList<DTO> convert(List<Table> tables){
        ArrayList<DTO> dtos = new ArrayList<>();
        for (Table table : tables){
            dtos.add(new DTO(table.getArea(), table.getWeight()));
        }
        return dtos;
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
