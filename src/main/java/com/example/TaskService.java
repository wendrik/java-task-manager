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
    public boolean deleteTask(int idTask){
        for (int i = 0; i < tasks.size(); i++){
            if (tasks.get(i).getId() == idTask){
                tasks.remove(i);
                return true;
            }
        }
        return false;
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

    public Task getTaskById(int id){
        for (Task task : tasks){
            if (task.getId() == id){
                return task;
            }
        }
        return null;
    }

}
