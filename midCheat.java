// Array List
ArrayList<Obj> listName = new ArrayList<>();
// Add New Item
listName.add(obj);

// For Each Loop
for (Obj i : listName) {

}

// If Else
if () {
    return;
} else if () {
    return;
} else {
    return;
}

// Table View
private TableView<Obj> tableName;
private TableColumn<Obj, String> colName;

public void init() {
    colName.setCellValueFactory(new PropertyValueFactory<>("objFieldName"));
    colName.setCellValueFactory(new PropertyValueFactory<>("objFieldName"));
}

// Load Table data 
tableName.getItems().addAll(listName); // Add all item from the list
tableName.getItems().clear();

// Strings
output = obj.toStr() + "\n" + "something"

// Combo Box
comboBox.getItems().addAll(1, "Thing");
comboBox.getValue(); // Get Value
getSelectionModel().getSelectedItem() == null // Check if anything is selected or not

// Radio Button
radioButton.isSelected(); // Returns true if the button is selected 

// Check Box
box.isSelected();

// Show/Hide FXML
.setVisible(true/false);
