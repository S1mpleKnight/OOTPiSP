package by.bsuir.oop.fourth.controller;

import by.bsuir.oop.fourth.container.Container;
import by.bsuir.oop.fourth.domain.furniture.Table;
import by.bsuir.oop.fourth.serialization.api.SerializeStrategy;
import by.bsuir.oop.fourth.serialization.impl.BinarySerializeStrategy;
import by.bsuir.oop.fourth.serialization.impl.CustomTablesSerializeStrategy;
import by.bsuir.oop.fourth.serialization.impl.YAMLSerializeStrategy;
import by.bsuir.oop.fourth.starter.Main;
import by.bsuir.oop.fourth.util.api.FileWorker;
import by.bsuir.oop.fourth.util.impl.Info;
import by.bsuir.oop.fourth.util.impl.SimpleFileWorker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

public final class PrimaryController {
    private static final Info info = Info.getInfo();
    private static final File file = new File(info.getSERIALIZE_FILE());
    private static SerializeStrategy strategy = YAMLSerializeStrategy.getYamlVersion();
    private static String choiceCipher;
    private static String choiceCompression;
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
    private ComboBox<String> compressionCombo;
    @FXML
    private CheckBox compressionCheckBox;
    @FXML
    private ComboBox<String> encryptionCombo;
    @FXML
    private CheckBox encryptionCheckBox;
    private ObservableList<String> compressions;
    private ObservableList<String> ciphers;

    public static String getChoiceCipher() {
        return choiceCipher;
    }

    public static String getChoiceCompression() {
        return choiceCompression;
    }

    @FXML
    void initialize() {
        ciphers = FXCollections.observableArrayList(Info.getCIPHERS()
                .stream()
                .map(Class::getName)
                .collect(Collectors.toList()));
        compressions = FXCollections.observableArrayList(Info.getCompressionMethods()
                .stream()
                .map(Class::getName)
                .collect(Collectors.toList()));
        compressionCombo.getItems().addAll(compressions);
        encryptionCombo.getItems().addAll(ciphers);

        encryptionCombo.setOnAction(e -> {
            choiceCipher = encryptionCombo.getValue();
        });

        compressionCombo.setOnAction(e -> {
            choiceCompression = compressionCombo.getValue();
        });

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
            if (!checkPlugins()){
                return;
            }
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
            if (!checkPlugins()){
                return;
            }
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

    private boolean checkPlugins(){
        if (encryptionCheckBox.isSelected() && choiceCipher == null){
            showAlert("Choose cipher", false);
            return false;
        }
        if (compressionCheckBox.isSelected() && choiceCompression == null){
            showAlert("Choose compression", false);
            return false;
        }
        return true;
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

    private void updateWorker(){
        FileWorker anotherWorker = SimpleFileWorker.getWorker();
        if (compressionCheckBox.isSelected()){
            //todo: updating worker with needed plugins params
        }
    }
}
