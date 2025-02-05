package midterm_2111652_sec1;

import java.util.ArrayList;

public class Trainee {
    private int id;
    private ArrayList<String> traningTitles = new ArrayList<>(); 

    public Trainee(int id, ArrayList<String> traningTitles) {
        this.id = id;
        this.traningTitles.addAll(traningTitles);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getTraningTitles() {
        return traningTitles;
    }

    public void setTraningTitles(ArrayList<String> traningTitles) {
        this.traningTitles.addAll(traningTitles);
    }

    @Override
    public String toString() {
        return "Trainee{" + "id=" + id + ", traningTitles=" + traningTitles.toString() + '}';
    }
    
    
}
