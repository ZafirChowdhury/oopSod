package com.cse.oop.final_section1_1234567;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Scene2DataProcessingController {
    @javafx.fxml.FXML
    private TableColumn<DummyMonitor, String> diagonalCol;
    @javafx.fxml.FXML
    private Text errorMessageLable;
    @javafx.fxml.FXML
    private TableView<DummyMonitor> monitorTableView;
    @javafx.fxml.FXML
    private TableColumn<DummyMonitor, String> resulutionCol;
    @javafx.fxml.FXML
    private TableColumn<DummyMonitor, String> modelCol;
    @javafx.fxml.FXML
    private TableColumn<DummyMonitor, String> ppiCol;
    @javafx.fxml.FXML
    private TableColumn<DummyMonitor, Float> priceCol;

    @javafx.fxml.FXML
    public void initialize() {
        modelCol.setCellValueFactory(new PropertyValueFactory<>("modle"));
        resulutionCol.setCellValueFactory(new PropertyValueFactory<>("resolution"));
        diagonalCol.setCellValueFactory(new PropertyValueFactory<>("diagonal"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        ppiCol.setCellValueFactory(new PropertyValueFactory<>("ppi"));
    }

    ArrayList<DummyMonitor> dummyMonitors = new ArrayList<>();

    @javafx.fxml.FXML
    public void backToScne1OnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene1-data-generation.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void loadDataFromBinOnClick(ActionEvent actionEvent) {
        try {
            File file = new File("m.bin");

            if (!file.exists()) {
                return;
            }

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {
                while (true) {
                    Monitor_1234567 monitor = (Monitor_1234567) ois.readObject();
                    dummyMonitors.add(new DummyMonitor(monitor.getModle(), monitor.getPPI(), monitor.getPrice(), monitor.getDiagonal(), monitor.getResolution()));
                }
            } catch (EOFException eof) {
                System.out.println("End of file reached");
            }


        } catch (Exception e) {
            errorMessageLable.setText("There was a error reading from bin!");
            System.out.println("There was a error reading from bin!");
            return;
        }

        monitorTableView.getItems().clear();
        monitorTableView.getItems().addAll(dummyMonitors);
    }
}
