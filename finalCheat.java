// Scene switching
// Same stage (Window)
FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
Parent root = fxmlLoader.load();

Scene scene = new Scene(root);

Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

stage.setScene(scene);
stage.show();

// Diffrent stage 
FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
Scene scene = new Scene(fxmlLoader.load());

Stage stage = new Stage();

stage.setTitle("Satge 2!");
stage.setScene(scene);
stage.show();

// Data passing
public void reciveData(String text) {
        output.setText(text);
}

FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene2.fxml"));

SController s = fxmlLoader.getController();
s.reciveData(textField.getText());

// read/write bin files
// Saving to bin file
File file = new File("file.bin");
FileOutputStream fos;
ObjectOutputStream oos;

try {
    if (file.exists()) {
        fos = new FileOutputStream(file, true);
        oos = new AppendableObjectOutputStream(fos);
    } else {
        fos = new FileOutputStream(file, true);
        oos = new ObjectOutputStream(fos);
    }

    oos.writeObject(obj);
    System.out.println(obj.toString() + "   Saved.");
    oos.close();

} catch(Exception ex) {
    System.out.println("There was a error while saving the bin file");
}

// Read all file to the arraylist
ArrayList<Obj> objList = new ArrayList<>();
File file;
FileInputStream fis;
ObjectInputStream ois;

try {
    file = new File("file.bin");
    fis = new FileInputStream(file);
    ois = new ObjectInputStream(fis);

    try {

        while (true) {
            Obj obj = ((Obj) ois.readObject());
            objList.add(obj)
        }

    } catch (EOFException eOFException) {
        System.out.println("bin file read successfully");
}

// Working code
try {
            file = new File("students.bin");

            if (!file.exists()) return;

            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            try {
                while (true) {
                    Student s = (Student) ois.readObject();
                    students.add(s);
                }
            } catch (EOFException e) {
                System.out.println("End of file reached");
                ois.close();
            }

        } catch(Exception e) {
            e.printStackTrace();
        }