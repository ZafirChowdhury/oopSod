package com.example.sp23c;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class MidExamSceneController
{
    @javafx.fxml.FXML
    private TextField valTextField;
    @javafx.fxml.FXML
    private Label postProcessingResultLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    private ArrayList<Integer> valList = new ArrayList<>();

    MyArr arr1;
    MyArr arr2;
    MyArr arr3;

    @javafx.fxml.FXML
    public void instantiateArr2AndClearValListButtonOnClick(ActionEvent actionEvent) {
        arr2 = new MyArr(valList);
        valList.clear();
    }

    @javafx.fxml.FXML
    public void instantiateArr1AndClearValListButtonOnClick(ActionEvent actionEvent) {
        arr1 = new MyArr(valList);
        valList.clear();
    }

    @javafx.fxml.FXML
    public void mergeAndShowButtonOnClick(ActionEvent actionEvent) {
        ArrayList<Integer> tempValList = arr1.merge(arr2);
        arr3 = new MyArr(tempValList);

        System.out.println(arr1.getVals().toString());
        System.out.println(arr1.getVals().toString());

        // Print Result
        String output = "Content of MyArray instance arr1 : " + arr1.toString()
                + "\n" + "Size of arr1 = " + arr1.getVals().size();


        postProcessingResultLabel.setText(output);

    }

    @javafx.fxml.FXML
    public void addElementToValList(ActionEvent actionEvent) {
        valList.add(Integer.parseInt(valTextField.getText()));
        valTextField.clear();
    }
}