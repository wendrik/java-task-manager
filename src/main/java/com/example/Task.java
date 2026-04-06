package com.example;

public class Task {
    private int id;
    private String title;
    private Boolean completed;

    public Task(int id, String title, boolean completed){
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

public int getId(){
        return id;
}
public String getTitle(){
        return title;
}
public Boolean getBool(){
        return completed;
}
    void print(){
        System.out.println(id + ": " + title + " " + completed);
    }

    public boolean markCompleted() {
        if (completed) {
            return false;
        }
        completed = true;
        return true;
    }
}


