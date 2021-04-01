package by.bsuir.oop.third.controller;

import by.bsuir.oop.third.container.Container;
import by.bsuir.oop.third.furniture.Table;
import by.bsuir.oop.third.info.Info;
import by.bsuir.oop.third.serialization.BinarySerializeStrategy;
import by.bsuir.oop.third.serialization.CustomTablesSerializeStrategy;
import by.bsuir.oop.third.serialization.SerializeStrategy;
import by.bsuir.oop.third.serialization.YAMLSerializeStrategy;
import by.bsuir.oop.third.starter.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class PrimaryController {
    private static SerializeStrategy strategy = YAMLSerializeStrategy.getYamlVersion();
    private static final Info info = Info.getInfo();
    private static final File file = new File(info.getFILE_PATH());
    private static Stage tableStage;

    public static Stage getTableStage() {
        return tableStage;
    }

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
            Container<Table> container = strategy.read(file);
            if (container == null) {
                showAlert("Container is not loaded", false);
                container = new Container();
            } else {
                showAlert("Success: information have been deserialized", true);
            }
            info.setTables(container);
        });

        serializeButton.setOnAction(e -> {
            String result = strategy.write(file, info.getTables());
            if (!result.equals("Success")) {
                showAlert(result, false);
            } else {
                showAlert(result + ": information have been serialized", true);
            }
        });

        tablesButton.setOnAction(e -> {
            try {
                Stage mainStage = Main.getStage();
                mainStage.hide();
                Stage stage = new Stage();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("table.fxml"))));
                stage.setTitle("Tables");
                stage.setResizable(false);
                tableStage = stage;
                stage.showAndWait();
                mainStage.show();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
    }

    private void showAlert(String message, boolean state) {
        Alert alert = new Alert(state ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
        alert.setHeaderText(state ? "Information" : "Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
