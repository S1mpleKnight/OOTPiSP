package by.bsuir.oop.third.controller;

import by.bsuir.oop.third.info.Info;
import by.bsuir.oop.third.serialization.BinarySerialize;
import by.bsuir.oop.third.serialization.CustomTablesSerialize;
import by.bsuir.oop.third.serialization.SerializeStrategy;
import by.bsuir.oop.third.serialization.YAMLSerialize;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class PrimaryController {
    private static SerializeStrategy strategy = YAMLSerialize.getYamlVersion();
    private static Info info = Info.getInfo();

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
    private Button tabelsButton;

    @FXML
    private Button sofaButton;

    @FXML
    void initialize() {
        yamlButton.setOnAction(e -> {
            strategy = YAMLSerialize.getYamlVersion();
        });

        customButton.setOnAction(e -> {
            strategy = CustomTablesSerialize.getCustomVersion();
        });

        binaryButton.setOnAction(e -> {
            strategy = BinarySerialize.getBinaryVersion();
        });
    }
}
