// Class Handel // No data in memory/ram
Student s;

// Class Instance // Data in memory
s = new Student(id, name);

// Data in memory // Class Instance
Student s2 = new Student("211131", "Labiba");

// If object is saved in a ver -> Named instance (s3) -> Name -> var
Student s3 = new Student("222131", "Adhora");
s3.getId();
s3.getName();
s3.setId("21");

// If object is not saved in a ver -> Anonymous instance
System.out.println(new Student("Shahad", "2111652").getName());

public class DataPakage {
    int ammountMb; // Defult // Pakage     // 2048 MB
    private int validityMin; // 4320
    private double price; // 50.00 TK
    private boolean isPrimium; // Fasle
}
