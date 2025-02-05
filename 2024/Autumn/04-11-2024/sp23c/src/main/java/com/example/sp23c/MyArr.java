package com.example.sp23c;

import java.util.ArrayList;

public class MyArr {
    private ArrayList<Integer> vals;

    public MyArr(ArrayList<Integer> vals) {
        this.vals = vals;
    }

    public ArrayList<Integer> getVals() {
        return vals;
    }

    public void setVals(ArrayList<Integer> vals) {
        this.vals = vals;
    }

    @Override
    public String toString() {
        String output = "";
        for (Integer v : this.vals) {
            output = output + v + " ";
        }

        return output;
    }

    public ArrayList<Integer> merge(MyArr arr) {
        ArrayList<Integer> arr3 = new ArrayList<>();

        arr3.addAll(this.vals);
        arr3.addAll(arr.getVals());

        return arr3;
    }
}
