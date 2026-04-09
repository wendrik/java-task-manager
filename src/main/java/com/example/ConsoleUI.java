package com.example;

import java.util.Scanner;

public class ConsoleUI {
    public final TaskService service;

    public ConsoleUI(TaskService service){ this.service = service; }

    Scanner reader = new Scanner(System.in);

    public void start(){
        int choiceMenu;

        while (true){
            System.out.println("Choice want you want: 1. Add task. " +
                    "2. Get all task. " +
                    "3. Mark task as completed. " +
                    "4. Delete task." +
                    "5. Exists by Id. " +
                    "6. Exit.");

            if(!reader.hasNextInt()){
                System.out.println("This is not a number. Try again.");
                reader.next();
                System.out.println("-----------------------------");
                continue;
            }

            choiceMenu = reader.nextInt();
            reader.nextLine();

            if (choiceMenu <= 0 || choiceMenu > 6){
                System.out.println("Not correct task");
                System.out.println("-----------------------------");
                continue;
            }
            break;
        }
        /*
        while (true){
            switch (choiceMenu) {
                case 1: //Add task
                    while (true) {

                        System.out.println("Add task : ");
                        System.out.println("If you finish write 0 ");
                        title = reader.nextLine();


                        if (title.equals("0")) {
                            System.out.println("Ваші завдання: ");
                            for (Task task : service.getAllTasks()) {
                                System.out.println(task);
                            }
                            break;
                        }
                        service.addTask(title);


                    }
                    break;
                case 2: //Get all task
                    System.out.println("Ваші завдання: ");
                    for (Task task : service.getAllTasks()) {
                        System.out.println(task);
                    }
                    break;
                case 3: //Mark task as completed.
                    while (true){
                        if(!reader.hasNextInt()){
                            System.out.println("This is not a number. Try again.");
                            reader.next();
                            System.out.println("-----------------------------");
                            continue;
                        }
                        taskComplete = reader.nextInt();
                        reader.nextLine();

                        service.completeTask(taskComplete);
                    }
                case 4: //Delete task
                    while (true){
                        if(!reader.hasNextInt()){
                            System.out.println("This is not a number. Try again.");
                            reader.next();
                            System.out.println("-----------------------------");
                            continue;
                        }

                        choiceMenu = reader.nextInt();
                        reader.nextLine();

                        service.deleteTask(choiceMenu);

                        System.out.println("You wanna delete more task? 1.Yes  2.Not");
                        nextDeleteTask = reader.nextInt();

                        if (nextDeleteTask == 1){
                            continue;
                        }
                        if (nextDeleteTask == 2){
                            break;
                        }
                    }
                case 5: //Exists by ID
                    System.out.println("Enter task id:");
                    existsId = reader.nextInt();
                    if (!service.existsById(existsId)){
                        System.out.println("Task not found!");
                    }
                case 6: //Exit
                    break;

            }
            System.out.println("You wanna do more something? 1. Yes. 2. Not(You print all task)");
            while (true){
                if(!reader.hasNextInt()){
                    System.out.println("This is not a number. Try again.");
                    reader.next();
                    System.out.println("-----------------------------");
                    continue;
                }
                choiceMenu = reader.nextInt();

                if (choiceMenu == 1){

                }
                if (choiceMenu == 2){
                    break;
                }
            }
            break;
        }

         */
        taskAction(choiceMenu);


    }

    public void taskAction(int choiceMenu){

    int taskComplete;
    int existsId;
    String title;
    int nextDeleteTask;

        while (true){
            switch (choiceMenu) {
                case 1: //Add task
                    while (true) {

                        System.out.println("Add task : ");
                        System.out.println("If you finish write 0 ");
                        title = reader.nextLine();


                        if (title.equals("0")) {
                            System.out.println("Ваші завдання: ");
                            for (Task task : service.getAllTasks()) {
                                System.out.println(task);
                            }
                            break;
                        }
                        service.addTask(title);


                    }
                    break;
                case 2: //Get all task
                    System.out.println("Ваші завдання: ");
                    for (Task task : service.getAllTasks()) {
                        System.out.println(task);
                    }
                    break;
                case 3: //Mark task as completed.
                    while (true){
                        System.out.println("What task you wanna mark complete: ");
                        if(!reader.hasNextInt()){
                            System.out.println("This is not a number. Try again.");
                            reader.next();
                            System.out.println("-----------------------------");
                            continue;
                        }

                        taskComplete = reader.nextInt();
                        reader.nextLine();

                        if (taskComplete == 0) {
                            System.out.println("Ваші завдання: ");
                            for (Task task : service.getAllTasks()) {
                                System.out.println(task);
                            }
                            break;
                        }

                        service.completeTask(taskComplete);

                    }
                    break;
                case 4: //Delete task
                    while (true){
                        System.out.println("What task you wanna delete(write number task):");
                        if(!reader.hasNextInt()){
                            System.out.println("This is not a number. Try again.");
                            reader.next();
                            System.out.println("-----------------------------");
                            continue;
                        }

                        choiceMenu = reader.nextInt();
                        reader.nextLine();

                        if (service.deleteTask(choiceMenu)){
                            System.out.println("Delete!");
                        }
                        else {
                            System.out.println("Task not found!");
                        }

                        System.out.println("You wanna delete more task? 1.Yes  2.Not");
                        nextDeleteTask = reader.nextInt();

                        if (nextDeleteTask == 1){
                            continue;
                        }
                        if (nextDeleteTask == 2){
                            break;
                        }
                    }
                    break;
                case 5: //Exists by ID
                    System.out.println("Enter task id:");
                    existsId = reader.nextInt();

                    Task task = service.getTaskById(existsId);

                    if (task == null){
                        System.out.println("Task not found");
                    }
                    else {
                        System.out.println(task);
                    }
                case 6: //Exit
                    break;

            }
            /*
            System.out.println("You wanna do more something? 1. Yes. 2. Not(You print all task)");
            while (true){
                if(!reader.hasNextInt()){
                    System.out.println("This is not a number. Try again.");
                    reader.next();
                    System.out.println("-----------------------------");
                    continue;
                }
                choiceMenu = reader.nextInt();

                if (choiceMenu == 1){

                }
                if (choiceMenu == 2){
                    break;
                }
            }
            */
            break;
        }
        printTask();
    }

    public void printTask(){
        int print;
        System.out.println("You wanna do more something? 1. Yes. 2. Not(You print all task)");
        while (true){
            if(!reader.hasNextInt()){
                System.out.println("This is not a number. Try again.");
                reader.next();
                System.out.println("-----------------------------");
                continue;
            }
            print = reader.nextInt();

            if (print == 1){
                start();
            }
            if (print == 2){
                for (Task task : service.getAllTasks()) {
                    System.out.println(task);
                }
            }
            break;
        }
    }
}

/*
* Ваші завдання:
* 1. блвблаґ
* 2. вілвіф
* 3. вфівфв
* */