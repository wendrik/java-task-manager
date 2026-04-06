package com.example;

import java.util.ArrayList;

public class Main {
    static void main(String[] args) {
        ArrayList<Task> task = new ArrayList<>();

        TaskService service = new TaskService(task);
        ConsoleUI ui = new ConsoleUI(service);

        ui.start();
    }
}
