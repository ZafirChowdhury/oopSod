package midterm_2111652_sec1;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class MidController implements Initializable {

    @FXML
    private ComboBox<Integer> idComboBox;
    @FXML
    private Label internName;
    @FXML
    private Label uniName;
    @FXML
    private Label satus;
    @FXML
    private CheckBox springBootCheckbox;
    @FXML
    private CheckBox blockChainCheckbox;
    @FXML
    private CheckBox communicationSkillCheckbox;
    @FXML
    private CheckBox cudaCheckbox;
    @FXML
    private Label errorLable;
    @FXML
    private TableView<Dummy> table;
    @FXML
    private TableColumn<Dummy, String> idCol;
    @FXML
    private TableColumn<Dummy, String> uniCol;
    @FXML
    private TableColumn<Dummy, String> paidCol;
    @FXML
    private TableColumn<Dummy, String> skillCol;
    @FXML
    private TableColumn<Dummy, String> noOfSkillCol;
    @FXML
    private AnchorPane searchResultLable;
    @FXML
    private ComboBox<?> uniCombobox;
    @FXML
    private ComboBox<?> paidStatusCombox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (Intern i : internArr) {
            idComboBox.getItems().add(i.getId());
        }
        
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        uniCol.setCellValueFactory(new PropertyValueFactory<>("uni"));
        paidCol.setCellValueFactory(new PropertyValueFactory<>("paid"));
        skillCol.setCellValueFactory(new PropertyValueFactory<>("skill"));
        noOfSkillCol.setCellValueFactory(new PropertyValueFactory<>("noOfTraning"));
        
        
    }

    Intern[] internArr = {
        new Intern(1, "Zafir", "IUB", "Unpaid"),
        new Intern(2, "Zafor", "IUB", "Paid"),
        new Intern(3, "Zahid", "NSU", "Unpaid"),
        new Intern(4, "Zarif", "IUB", "Paid"),
        new Intern(5, "Asif", "Brack", "Paid"),
        new Intern(6, "Amit", "Brack", "Unpaid"),
        new Intern(7, "Arnob", "IUB", "Paid"),
        new Intern(8, "Aqif", "NSU", "Unpaid"),
        new Intern(9, "Anonna", "Brack", "Unpaid"),
        new Intern(10, "Aria", "NSU", "Paid")
    };
    
    ArrayList<Trainee> traineeList = new ArrayList<>();
    ArrayList<String> tempSkillList = new ArrayList<>();
    ArrayList<Dummy> dummyArray = new ArrayList<>();

    @FXML
    private void showInternData(ActionEvent event) {
        int selectedInternId = idComboBox.getValue();
        
        internName.setText(null);
        uniName.setText(null);
        satus.setText(null);
        
        for (Intern i : internArr) {
            if (i.getId() == selectedInternId){
                internName.setText(i.getInternName());
                uniName.setText(i.getUniName());
                satus.setText(i.getPaymentStatus());
                return;
            }
        }
    }

    @FXML
    private void addNewTraineeButtonMouseOnClicked(ActionEvent event) {
        errorLable.setText(null);
        tempSkillList.clear();
        
        if (springBootCheckbox.isSelected()) tempSkillList.add("Spring Boot");
        if (communicationSkillCheckbox.isSelected()) tempSkillList.add("Communication skill");
        if (blockChainCheckbox.isSelected()) tempSkillList.add("Block Chain"); 
        if (cudaCheckbox.isSelected()) tempSkillList.add("CUDA Multicore Programming");
        
        if (tempSkillList.isEmpty()) {
            errorLable.setText("Atleast one checkbox must be selected");
            return;
        }
        
        int internId = idComboBox.getValue();
        
        // Check if tranee allready exists
        if (!traineeList.isEmpty()) {
            for (Trainee t : traineeList) {
                if (t.getId() == internId) {
                    t.setTraningTitles(tempSkillList);                
                }
            }
        }
        
        Trainee newTrainee = new Trainee(internId, tempSkillList);
        traineeList.add(newTrainee);
        
        // For debuging
        System.out.println(newTrainee.toString());
    }

    @FXML
    private void showTraningInfoButtonMouseOnClicked(ActionEvent event) {
        table.getItems().clear();
        
        for (Intern i : internArr) {
            Dummy newDummy = new Dummy(i.getId(), i.getUniName(), i.getPaymentStatus());
            
            for (Trainee t : traineeList) {
                if (t.getId() == i.getId()) {
                    newDummy.setSkill(t.getTraningTitles());
                    newDummy.setNoOfTraning();
                }
            }
            
            dummyArray.add(newDummy);
        }
        
        for (Dummy d : dummyArray) {
            if (d.getNoOfTraning() != 0) {
                table.getItems().add(d);
            }
        }
    }

    @FXML
    private void showTraineeCountButtonOnClicked(ActionEvent event) {
    }
    
    
    
}
