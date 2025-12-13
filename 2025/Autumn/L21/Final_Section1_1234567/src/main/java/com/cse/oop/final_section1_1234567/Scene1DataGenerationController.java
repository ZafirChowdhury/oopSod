package com.cse.oop.final_section1_1234567;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Scene1DataGenerationController {
    @javafx.fxml.FXML
    private ComboBox<String> diagonalComboBox;
    @javafx.fxml.FXML
    private TableColumn<Monitor_1234567, String> diagonalCol;
    @javafx.fxml.FXML
    private ComboBox<String> resolutionComboBox;
    @javafx.fxml.FXML
    private Text errorMessageLable;
    @javafx.fxml.FXML
    private TextField priceTextField;
    @javafx.fxml.FXML
    private TextField modelTextField;
    @javafx.fxml.FXML
    private TableView<Monitor_1234567> monitorTableView;
    @javafx.fxml.FXML
    private TableColumn<Monitor_1234567, String> resulutionCol;
    @javafx.fxml.FXML
    private TableColumn<Monitor_1234567, String> modelCol;
    @javafx.fxml.FXML
    private TableColumn<Monitor_1234567, Float> priceCol;

    @javafx.fxml.FXML
    public void initialize() {
        resolutionComboBox.getItems().addAll("HD", "HD+", "Full-HD", "QHD");
        diagonalComboBox.getItems().addAll("17", "19", "22", "24");

        modelCol.setCellValueFactory(new PropertyValueFactory<>("modle"));
        resulutionCol.setCellValueFactory(new PropertyValueFactory<>("resolution"));
        diagonalCol.setCellValueFactory(new PropertyValueFactory<>("diagonal"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    ArrayList<Monitor_1234567> monitors = new ArrayList<>();

    @javafx.fxml.FXML
    public void addMonitorOnClick(ActionEvent actionEvent) {
        if (modelTextField.getText().trim().isEmpty()) {
            errorMessageLable.setText("Model field cant be empty!");
            return;
        }

        if (priceTextField.getText().trim().isEmpty()) {
            errorMessageLable.setText("Price field cant be empty!");
            return;
        }

        if (resolutionComboBox.getSelectionModel().getSelectedItem() == null) {
            errorMessageLable.setText("Pleas select a resolution!");
            return;
        }

        if (diagonalComboBox.getSelectionModel().getSelectedItem() == null) {
            errorMessageLable.setText("Please select a diagonal size!");
            return;
        }

        String modle = modelTextField.getText();
        String resolution = resolutionComboBox.getValue();
        String diagonal = diagonalComboBox.getValue();
        float price = Float.parseFloat(priceTextField.getText());

        Monitor_1234567 monitor = new Monitor_1234567(modle, price, diagonal, resolution);

        monitors.add(monitor);

        monitorTableView.getItems().clear();
        monitorTableView.getItems().addAll(monitors);
    }

    @javafx.fxml.FXML
    public void goToScene2OnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene2-data-processing.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

        /*
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene1-data-generation.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        */
    }

    @javafx.fxml.FXML
    public void saveToBinOnClikc(ActionEvent actionEvent) {
        for (Monitor_1234567 monitor: monitors) {
            File file = new File("m.bin");
            FileOutputStream fos;
            ObjectOutputStream oos;

            try {

                if (file.exists()) {
                    fos = new FileOutputStream(file, true);
                    oos = new AppendableObjectOutputStream(fos);
                } else {
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                }

                oos.writeObject(monitor);
                oos.close();

            } catch (Exception e) {
                System.out.println("There was a error while saving to bin!");
            }
        }
    }
}
