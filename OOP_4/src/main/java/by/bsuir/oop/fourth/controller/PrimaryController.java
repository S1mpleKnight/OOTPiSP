package by.bsuir.oop.fourth.controller;
import by.bsuir.oop.fourth.container.Container;
import by.bsuir.oop.fourth.domain.furniture.Table;
import by.bsuir.oop.fourth.util.Info;
import by.bsuir.oop.fourth.serialization.api.SerializeStrategy;
import by.bsuir.oop.fourth.serialization.impl.BinarySerializeStrategy;
import by.bsuir.oop.fourth.serialization.impl.CustomTablesSerializeStrategy;
import by.bsuir.oop.fourth.serialization.impl.YAMLSerializeStrategy;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import by.bsuir.oop.fourth.starter.Main;

import java.io.File;
import java.io.IOException;

public final class PrimaryController {
    private static final Info info = Info.getInfo();
    private static final File file = new File(info.getFILE_PATH());
    private static SerializeStrategy strategy = YAMLSerializeStrategy.getYamlVersion();
    @FXML
    private RadioButton yamlButton;
    @FXML
    private ToggleGroup serializationType;
    @FXML
    private RadioButton binaryButton;
    @FXML
    private RadioButton customButton;
    @FXML
    private Button serializeButton;
    @FXML
    private Button deserializeButton;
    @FXML
    private Button tablesButton;
    @FXML
    private Button sofaButton;

    @FXML
    void initialize() {
        yamlButton.setOnAction(e -> {
            strategy = YAMLSerializeStrategy.getYamlVersion();
        });

        customButton.setOnAction(e -> {
            strategy = CustomTablesSerializeStrategy.getCustomVersion();
        });

        binaryButton.setOnAction(e -> {
            strategy = BinarySerializeStrategy.getBinaryVersion();
        });

        deserializeButton.setOnAction(e -> {
            Container<Table> oldContainer = info.getTables();
            Container<Table> container;
            try {
                container = strategy.read(file);
            } catch (IOException ioException) {
                showAlert("Container is not loaded", false);
                container = oldContainer;
            }
            showAlert("Success: information have been deserialized", true);
            info.setTables(container);
        });

        serializeButton.setOnAction(e -> {
            boolean result;
            try {
                result = strategy.write(file, info.getTables());
            } catch (IOException ioException) {
                result = false;
            }
            showAlert(result);
        });

        tablesButton.setOnAction(e -> {
            try {
                showTables();
            } catch (IOException exception) {
                showAlert(exception.getMessage(), false);
            }
        });
    }

    private void showTables() throws IOException {
        Main.setScene("table.fxml", PrimaryController.class);
    }

    private void showAlert(boolean state) {
        Alert alert = new Alert(state ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
        alert.setHeaderText(state ? "Information" : "Error");
        alert.setContentText(state ? "Information have been serialized" : "Some mistakes happened");
        alert.showAndWait();
    }

    private void showAlert(String message, boolean state) {
        Alert alert = new Alert(state ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
        alert.setHeaderText(state ? "Information" : "Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
