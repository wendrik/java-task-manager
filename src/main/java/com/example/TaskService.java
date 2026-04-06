package com.example;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final ArrayList<Task> task;
    private int nextId = 1;

    TaskService(ArrayList<Task> task) {
        this.task = task;
    }
    private List<Task> tasks = new ArrayList<>();

    public void addTask(String title){
        Task task = new Task(nextId, title, false);
        tasks.add(task);
        nextId++;
    }

    public List<Task> getAllTasks() {
        return tasks;
    }
    public void deleteTask(int idTask){
        for(Task i : tasks){
            if (i.getId() == idTask){
                tasks.remove(i);
            }
        }
    }

    public boolean completeTask(int id){
        for (Task i : tasks){
            if (i.getId() == id){
                return i.markCompleted();
            }
        }
        return false;
    }

    public boolean existsById(int id){
        for (Task i : tasks){
            if (i.getId() == id){
                return true;
            }
        }
        return false;
    }

}
