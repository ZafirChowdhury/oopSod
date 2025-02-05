package com.example.sp23c;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Collections;

public class MidExamSceneController
{
    @javafx.fxml.FXML
    private TextField valTextField;
    @javafx.fxml.FXML
    private Label postProcessingResultLabel;
    @javafx.fxml.FXML
    private RadioButton forwardRadioButton;
    @javafx.fxml.FXML
    private ToggleGroup arrGroup;
    @javafx.fxml.FXML
    private RadioButton arr3RadioButton;
    @javafx.fxml.FXML
    private ToggleGroup orderGroup;
    @javafx.fxml.FXML
    private RadioButton arr2RadioButton;
    @javafx.fxml.FXML
    private Label finalOutput;
    @javafx.fxml.FXML
    private RadioButton arr1RadioButton;
    @javafx.fxml.FXML
    private RadioButton backwardRadioButton;
    @javafx.fxml.FXML
    private ComboBox<String> oddEvenComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        oddEvenComboBox.getItems().addAll("Odd", "Even");
    }

    ArrayList<Integer> valList = new ArrayList<>();

    MyArr arr1 = new MyArr(new ArrayList<Integer>());
    MyArr arr2 = new MyArr(new ArrayList<Integer>());
    MyArr arr3 = new MyArr(new ArrayList<Integer>());

    @javafx.fxml.FXML
    public void instantiateArr2AndClearValListButtonOnClick(ActionEvent actionEvent) {
        arr2.getVals().addAll(valList);
        valList.clear();
    }

    @javafx.fxml.FXML
    public void instantiateArr1AndClearValListButtonOnClick(ActionEvent actionEvent) {
        arr1.getVals().addAll(valList);
        valList.clear();
    }

    @javafx.fxml.FXML
    public void mergeAndShowButtonOnClick(ActionEvent actionEvent) {
        String output = "";
        if (arr1.getVals().isEmpty()) {
            output = "arr1 is Empty" + "\n" + "\n"
                    + "Content of MyArray instance arr2 : " + arr2.toString()
                    + "\n" +  "Size of arr2 = " + arr2.getVals().size();

            postProcessingResultLabel.setText(output);
            return;
        }

        if (arr2.getVals().isEmpty()) {
            output = "arr2 is Empty" + "\n" + "\n"
                    + "Content of MyArray instance arr1 : " + arr1.toString()
                    + "\n" +  "Size of arr1 = " + arr1.getVals().size();

            postProcessingResultLabel.setText(output);
            return;
        }

        // Merge
        arr3.setVals(arr1.merge(arr2));

        // Print Result
        output = "Content of MyArray instance arr1 : " + arr1.toString()
                + "\n" + "Size of arr1 = " + arr1.getVals().size()

                + "\n" + "\n"

                + "Content of MyArray instance arr1 : " + arr2.toString()
                + "\n" +  "Size of arr2 = " + arr2.getVals().size()

                + "\n" + "\n"

                + "Content of Merged instance arr3 : " + arr3.toString()
                + "\n" +  "Size of arr3 = " + arr3.getVals().size();



        postProcessingResultLabel.setText(output);

    }

    @javafx.fxml.FXML
    public void addElementToValList(ActionEvent actionEvent) {
        valList.add(Integer.parseInt(valTextField.getText()));
        valTextField.clear();
    }

    @javafx.fxml.FXML
    public void traverseAndShowButtonOnClick(ActionEvent actionEvent) {
        ArrayList<Integer> tempArr = new ArrayList<>();

        if (arr1RadioButton.isSelected()) {
            tempArr.addAll(arr1.getVals());
        } else if (arr2RadioButton.isSelected()) {
            tempArr.addAll(arr2.getVals());
        } else {
            tempArr.addAll(arr3.getVals());
        }

        ArrayList<Integer> outputArr = new ArrayList<>();
        if (oddEvenComboBox.getValue().equals("Odd")) {
            for (Integer i : tempArr) {
                if (i % 2 != 0) {
                    outputArr.add(i);
                }
            }
        } else {
            for (Integer i : tempArr) {
                if (i % 2 == 0) {
                    outputArr.add(i);
                }
            }
        }

        if (backwardRadioButton.isSelected()) {
            Collections.reverse(outputArr);
        }

        finalOutput.setText(outputArr.toString());
    }
}