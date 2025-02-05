package midterm_2111652_sec1;

import java.util.ArrayList;

public class Dummy {
    private int id;
    private String uni;
    private String paid;
    private ArrayList<String> skill = new ArrayList<>(); 
    private int noOfTraning;

    public Dummy(int id, String uni, String paid) {
        this.id = id;
        this.uni = uni;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public ArrayList<String> getSkill() {
        return skill;
    }

    public void setSkill(ArrayList<String> skill) {
        this.skill = skill;
    }

    public int getNoOfTraning() {
        return noOfTraning;
    }

    public void setNoOfTraning() {
        this.noOfTraning = skill.size();
    }
    
    
}
