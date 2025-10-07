package com.example.studentobj;

public class Student {
    // 7 digit
    private String id;
    public String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.length() != 7) {
            return ;
        }

        this.id = id;
    }
}
