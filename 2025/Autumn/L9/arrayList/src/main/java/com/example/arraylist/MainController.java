package com.example.arraylist;

import java.util.ArrayList;

public class MainController
{
    @javafx.fxml.FXML
    public void initialize() {
        // array -> Static List  C/C++
        // list -> Dynamic List Python
        // [1, 2, 2.2, "String"].append() Dynamic Size // Any Type

        // arrayList -> Dynamic Size // Static Type

        ArrayList<Integer> intList = new ArrayList<>();

        // Adding
        intList.add(10);  // 0
        intList.add(20);  // 1
        intList.add(30);  // 2
        intList.add(40);  // 3
        intList.add(50);  // 4

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(intList.get(i));
        }

        for (Integer i : intList) {
            System.out.println(i);
        }



        //System.out.println(intList.get(2));
        // intList[2]

        //System.out.println(intList);

        //intList.remove(4); // removes number 5 at index 4
        //intList.remove(3);

        //System.out.println(intList);

        //intList.clear();
        //System.out.println(intList);

    }
}